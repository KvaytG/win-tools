package ru.kvaytg.wintools.util;

import java.util.Locale;
import org.jetbrains.annotations.ApiStatus.Internal;

/**
 * INTERNAL! Do not use directly.
 * Windows-specific utilities for WinTools internal needs.
 *
 * @apiNote This class is not part of the public API.
 * @implNote Implementation may change or be removed without notice.
 */
@Internal
public final class WindowsUtils {

    private WindowsUtils() {
        throw new AssertionError("No instances allowed");
    }

    private static final class Holder {

        static final boolean IS_WINDOWS = detectWindows();

        private static boolean detectWindows() {
            String osName = System.getProperty("os.name", "");
            return osName.toLowerCase(Locale.ENGLISH).startsWith("windows");
        }

    }

    public static boolean isWindows() {
        return Holder.IS_WINDOWS;
    }

}