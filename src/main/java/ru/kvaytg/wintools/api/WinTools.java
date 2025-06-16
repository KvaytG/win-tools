package ru.kvaytg.wintools.api;

import ru.kvaytg.wintools.util.WindowsUtils;

@SuppressWarnings("unused")
public final class WinTools {

    public static final String NAME = WinTools.class.getSimpleName();

    private WinTools() {
        throw new AssertionError("No instances allowed");
    }

    public static boolean isWindows() {
        return WindowsUtils.isWindows();
    }

}