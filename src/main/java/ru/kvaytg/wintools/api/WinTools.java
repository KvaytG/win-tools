package ru.kvaytg.wintools.api;

import ru.kvaytg.wintools.util.WindowsUtils;

@SuppressWarnings("unused")
public final class WinTools {

    public static final String NAME = WinTools.class.getSimpleName();

    private static volatile boolean dangerousOperationsEnabled = false;

    private WinTools() {
        throw new AssertionError("No instances allowed");
    }

    public static synchronized void setDangerOpsEnabled(boolean enabled) {
        dangerousOperationsEnabled = enabled;
    }

    public static boolean isDangerOpsEnabled() {
        return dangerousOperationsEnabled;
    }

    public static boolean isWindows() {
        return WindowsUtils.isWindows();
    }

}