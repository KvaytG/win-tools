package ru.kvaytg.wintools.internal.extra;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;
import ru.kvaytg.wintools.internal.util.JvmUtils;

/**
 * INTERNAL! Do not use directly.
 *
 * @apiNote This class is not part of the public API.
 * @implNote Implementation may change or be removed without notice.
 */
public final class WinToolsExtra {

    public static KeyListenerInternalCallback holdCallback;

    private WinToolsExtra() {
        throw new AssertionError("No instances allowed");
    }

    private interface WinToolsLibrary extends Library {

        WinToolsLibrary INSTANCE = Native.load(
                "WinToolsExtra" + (JvmUtils.is64Bit() ? "64" : "32"),
                WinToolsLibrary.class
        );

        void registerKeyListener(KeyListenerInternalCallback callback);

        void unregisterKeyListener();

        void sendKeyDown(int vkCode);

        void sendKeyUp(int vkCode);

    }

    public static void nativeKeyDown(int vkCode) {
        WinToolsLibrary.INSTANCE.sendKeyDown(vkCode);
    }

    public static void nativeKeyUp(int vkCode) {
        WinToolsLibrary.INSTANCE.sendKeyUp(vkCode);
    }

    public interface KeyListenerInternalCallback extends Callback {

        @SuppressWarnings("unused")
        void invoke(int vkCode);
        
    }

    public static void initNativeKeyListener(KeyListenerInternalCallback callback) {
        holdCallback = callback;
        WinToolsLibrary.INSTANCE.registerKeyListener(callback);
    }

    public static void stopNativeKeyListener() {
        WinToolsLibrary.INSTANCE.unregisterKeyListener();
        holdCallback = null;
    }

}