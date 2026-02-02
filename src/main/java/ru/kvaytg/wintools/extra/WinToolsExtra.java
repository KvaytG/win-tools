package ru.kvaytg.wintools.extra;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;
import ru.kvaytg.wintools.util.JvmUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides access to additional Windows-specific utilities extending the core WinTools library.
 * The primary feature of this class is the global keyboard event interception.
 *
 * <p>This class dynamically loads a native library (DLL) matching the JVM architecture (x86 or x64).
 * The corresponding DLLs must be present in the library search path or within the application's resources.</p>
 *
 * <b>Security Note:</b> The hooks utilized by this class are global. Events will be captured
 * even when the application is minimized or running in the background.
 *
 * @author KvaytG
 * @since 1.1.0
 */
@SuppressWarnings("unused")
public final class WinToolsExtra {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private WinToolsExtra() {
        throw new AssertionError("No instances allowed");
    }

    /**
     * Internal JNA interface to communicate with WinToolsExtra32/64.dll.
     */
    private interface WinToolsLibrary extends Library {
        /** Automatically determines the library name based on JVM bitness. */
        String LIBRARY_NAME = "WinToolsExtra" + (JvmUtils.is64Bit() ? "64" : "32");

        /** The singleton instance of the native library. */
        WinToolsLibrary INSTANCE = Native.load(LIBRARY_NAME, WinToolsLibrary.class);

        /**
         * Registers a callback function in the native C++ code.
         * * @param callback The callback object to be invoked on key events.
         */
        void registerKeyListener(KeyListenerInternalCallback callback);
    }

    /**
     * Internal JNA Callback interface.
     * The method name 'invoke' is required by JNA conventions for function pointers.
     */
    private interface KeyListenerInternalCallback extends Callback {
        void invoke(int vkCode);
    }

    /** List of active subscribers for keyboard events. */
    private static final List<KeyboardListener> subscribers = new ArrayList<>();

    /** * Static reference to the callback.
     * Must be kept in memory to prevent the Garbage Collector from reclaiming it,
     * which would lead to an Access Violation in the native code.
     */
    private static KeyListenerInternalCallback nativeCallback;

    /** Flag indicating whether the native hook has been initialized. */
    private static boolean isStarted = false;

    /**
     * Adds a listener for global keyboard events.
     * The native hook is automatically initialized when the first listener is added.
     *
     * @param listener An implementation of {@link KeyboardListener}.
     * @throws UnsatisfiedLinkError if the native library cannot be loaded.
     */
    public static void addKeyboardListener(KeyboardListener listener) {
        if (!isStarted) {
            startNativeHook();
        }
        synchronized (subscribers) {
            subscribers.add(listener);
        }
    }

    /**
     * Removes a listener from the event distribution list.
     *
     * @param listener The listener to be removed.
     */
    public static void removeKeyboardListener(KeyboardListener listener) {
        synchronized (subscribers) {
            subscribers.remove(listener);
        }
    }

    /**
     * Initializes the native thread for key listening.
     * Creates a bridge between Windows system events (WH_KEYBOARD_LL) and the JVM.
     */
    private static void startNativeHook() {
        nativeCallback = (vkCode) -> {
            synchronized (subscribers) {
                for (KeyboardListener s : subscribers) {
                    s.onKeyPress(vkCode);
                }
            }
        };
        WinToolsLibrary.INSTANCE.registerKeyListener(nativeCallback);
        isStarted = true;
    }

}