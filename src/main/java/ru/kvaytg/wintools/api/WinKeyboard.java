package ru.kvaytg.wintools.api;

import ru.kvaytg.wintools.extra.KeyboardListener;
import ru.kvaytg.wintools.extra.WinToolsExtra;
import ru.kvaytg.wintools.util.JvmUtils;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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

    /**
     * Private constructor to prevent instantiation.
     */
    private WinKeyboard() {
        throw new AssertionError("No instances allowed");
    }

    /**
     * Adds a listener for global keyboard events.
     * The native hook is automatically initialized when the first listener is added.
     *
     * @param listener An implementation of {@link KeyboardListener}.
     * @throws RuntimeException if the OS is not Windows.
     * @throws UnsatisfiedLinkError if the native library cannot be loaded.
     */
    public static void addListener(KeyboardListener listener) {
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
    public static void removeListener(KeyboardListener listener) {
        subscribers.remove(listener);
    }

    /**
     * Initializes the bridge between Windows system events and the JVM.
     */
    private static void startNativeHook() {
        if (!JvmUtils.isWindows()) {
            throw new RuntimeException("WinKeyboard only works on Windows");
        }
        nativeCallback = (vkCode) -> {
            for (KeyboardListener s : subscribers) {
                s.onKeyPress(vkCode);
            }
        };
        WinToolsExtra.initNativeKeyListener(nativeCallback);
        isStarted = true;
    }

}