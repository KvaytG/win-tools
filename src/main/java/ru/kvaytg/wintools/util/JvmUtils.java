package ru.kvaytg.wintools.util;

import java.util.Locale;
import org.jetbrains.annotations.ApiStatus.Internal;

/**
 * INTERNAL! Do not use directly.
 *
 * @apiNote This class is not part of the public API.
 * @implNote Implementation may change or be removed without notice.
 */
@Internal
public final class JvmUtils {

    private JvmUtils() {
        throw new AssertionError("No instances allowed");
    }

    private static final class Holder {

        static final boolean IS_WINDOWS = detectWindows();
        static final boolean IS_64_BIT = detectBitDepth();

        private static boolean detectWindows() {
            String osName = System.getProperty("os.name", "");
            return osName.toLowerCase(Locale.ENGLISH).startsWith("windows");
        }

        private static boolean detectBitDepth() {
            return System.getProperty("os.arch").contains("64");
        }

    }

    public static boolean isWindows() {
        return Holder.IS_WINDOWS;
    }

    public static boolean is64Bit() {
        return Holder.IS_64_BIT;
    }

}