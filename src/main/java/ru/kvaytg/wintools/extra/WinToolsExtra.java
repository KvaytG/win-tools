package ru.kvaytg.wintools.extra;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;
import ru.kvaytg.wintools.api.WinKeyboard;
import ru.kvaytg.wintools.util.JvmUtils;

/**
 * Low-level utility for loading and interacting with native Windows libraries.
 * Provides a bridge between the JVM and native C++ hooks.
 *
 * <p>Starting from version 1.2.0, this class serves as a proxy for the new API.
 * High-level features have been moved to the {@code ru.kvaytg.wintools.api} package.</p>
 *
 * @author KvaytG
 * @since 1.1.0
 */
public final class WinToolsExtra {

    private WinToolsExtra() {
        throw new AssertionError("No instances allowed");
    }

    /**
     * Internal JNA interface to communicate with the native DLL.
     */
    private interface WinToolsLibrary extends Library {

        WinToolsLibrary INSTANCE = Native.load(
                "WinToolsExtra" + (JvmUtils.is64Bit() ? "64" : "32"),
                WinToolsLibrary.class
        );

        void registerKeyListener(KeyListenerInternalCallback callback);

    }

    /**
     * Internal JNA Callback interface for keyboard events.
     * The method name 'invoke' is required by JNA conventions for function pointers.
     */
    public interface KeyListenerInternalCallback extends Callback {

        @SuppressWarnings("unused")
        void invoke(int vkCode);
        
    }

    /**
     * Low-level entry point to register a native keyboard hook.
     * This method is intended for internal use by the API package.
     *
     * @param callback The callback to be triggered by native code.
     */
    public static void initNativeKeyListener(KeyListenerInternalCallback callback) {
        WinToolsLibrary.INSTANCE.registerKeyListener(callback);
    }

    /**
     * @deprecated Use {@link WinKeyboard#addListener(KeyboardListener)} instead.
     */
    @Deprecated
    public static void addKeyboardListener(KeyboardListener listener) {
        WinKeyboard.addListener(listener);
    }

    /**
     * @deprecated Use {@link WinKeyboard#removeListener(KeyboardListener)} instead.
     */
    @Deprecated
    public static void removeKeyboardListener(KeyboardListener listener) {
        WinKeyboard.removeListener(listener);
    }

}