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

    public static boolean isWindowsOS() {
        return Holder.IS_WINDOWS;
    }

    private static class Holder {

        static final boolean IS_WINDOWS = detectWindows();

        private static boolean detectWindows() {
            String osName = System.getProperty("os.name");
            if (osName == null) return false;
            final String normalized = osName.toLowerCase(Locale.ENGLISH);
            return normalized.startsWith("windows");
        }

    }

}