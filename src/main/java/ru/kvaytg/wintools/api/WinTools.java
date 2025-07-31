package ru.kvaytg.wintools.api;

import ru.kvaytg.wintools.util.JvmUtils;

/**
 * Core utility class for global settings and environment checks
 */
@SuppressWarnings("unused")
public final class WinTools {

    /**
     * The simple name of this class ("WinTools").
     */
    public static final String NAME = WinTools.class.getSimpleName();

    /**
     * Indicates whether dangerous operations (like BSOD) are allowed.
     */
    private static volatile boolean dangerousOperationsEnabled = false;

    /**
     * Private constructor to prevent instantiation.
     */
    private WinTools() {
        throw new AssertionError("No instances allowed");
    }

    /**
     * Enables or disables permission to run dangerous operations.
     *
     * @param enabled {@code true} to allow dangerous operations; {@code false} to block them
     */
    public static synchronized void setDangerOpsEnabled(boolean enabled) {
        dangerousOperationsEnabled = enabled;
    }

    /**
     * Checks whether dangerous operations are currently enabled.
     *
     * @return {@code true} if dangerous operations are allowed; {@code false} otherwise
     */
    public static boolean isDangerOpsEnabled() {
        return dangerousOperationsEnabled;
    }

    /**
     * Checks if the current operating system is Windows.
     *
     * @return {@code true} if running on Windows; {@code false} otherwise
     */
    public static boolean isWindows() {
        return JvmUtils.isWindows();
    }

}