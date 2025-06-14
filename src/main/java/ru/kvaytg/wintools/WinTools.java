package ru.kvaytg.wintools;

import me.adasdead.WTools.wCore;

@SuppressWarnings("unused")
public final class WinTools {

    public static final String NAME = WinTools.class.getSimpleName();

    private WinTools() {
        throw new AssertionError("No instances allowed");
    }

    public static boolean isWindowsOS() {
        return wCore.isWindowsOS();
    }

}