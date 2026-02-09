package ru.kvaytg.wintools.api;

import ru.kvaytg.wintools.extra.KeyboardListener;
import ru.kvaytg.wintools.extra.WinToolsExtra;
import ru.kvaytg.wintools.util.JvmUtils;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Public API for global keyboard event interception on Windows.
 *
 * <p>This class manages a global low-level keyboard hook (WH_KEYBOARD_LL)
 * and distributes events to registered listeners.</p>
 *
 * <b>Note:</b> Since this utilizes global hooks, events are captured
 * even if the application is not in focus.
 *
 * @author KvaytG
 * @since 1.2.0
 */
public final class WinKeyboard {

    private static WinToolsExtra.KeyListenerInternalCallback nativeCallback;

    private static final List<KeyboardListener> subscribers = new CopyOnWriteArrayList<>();
    private static boolean isStarted = false;

    private static final ExecutorService eventExecutor = Executors.newSingleThreadExecutor(r -> {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    });

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(WinKeyboard::stopNativeHook));
    }

    /**
     * Private constructor to prevent instantiation.
     */
    private WinKeyboard() {
        throw new AssertionError("No instances allowed");
    }

    /**
     * Sends a native key down (press) event.
     *
     * @param vkCode the virtual-key code to press
     */
    public static void pressKeyDown(int vkCode) {
        checkWindows();
        WinToolsExtra.nativeKeyDown(vkCode);
    }

    /**
     * Sends a native key up (release) event.
     *
     * @param vkCode the virtual-key code to release
     */
    public static void pressKeyUp(int vkCode) {
        checkWindows();
        WinToolsExtra.nativeKeyUp(vkCode);
    }

    /**
     * Sends a full key press (down + up).
     *
     * @param vkCode the virtual-key code to press
     */
    @SuppressWarnings("unused")
    public static void pressKey(int vkCode) {
        pressKeyDown(vkCode);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("pressKey() interrupted: " + e.getMessage());
        }
        pressKeyUp(vkCode);
    }

    /**
     * Adds a listener for global keyboard events.
     * The native hook is automatically initialized when the first listener is added.
     *
     * @param listener An implementation of {@link KeyboardListener}.
     * @throws RuntimeException if the OS is not Windows.
     * @throws UnsatisfiedLinkError if the native library cannot be loaded.
     */
    public static synchronized void addListener(KeyboardListener listener) {
        if (!isStarted) {
            startNativeHook();
        }
        subscribers.add(listener);
    }

    /**
     * Removes a listener from the distribution list.
     *
     * @param listener The listener to be removed.
     */
    public static synchronized void removeListener(KeyboardListener listener) {
        subscribers.remove(listener);
        if (subscribers.isEmpty() && isStarted) {
            stopNativeHook();
        }
    }

    /**
     * Initializes the bridge between Windows system events and the JVM.
     */
    private static void startNativeHook() {
        checkWindows();
        nativeCallback = (vkCode) -> eventExecutor.submit(() -> {
            for (KeyboardListener s : subscribers) {
                try {
                    s.onKeyPress(vkCode);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        });
        WinToolsExtra.initNativeKeyListener(nativeCallback);
        isStarted = true;
    }

    /**
     * Safely stops the native hook and releases resources.
     */
    private static synchronized void stopNativeHook() {
        if (isStarted) {
            WinToolsExtra.stopNativeKeyListener();
            nativeCallback = null;
            isStarted = false;
        }
    }

    private static void checkWindows() {
        if (!JvmUtils.isWindows()) {
            throw new RuntimeException("WinKeyboard only works on Windows");
        }
    }

}