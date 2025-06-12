package ru.kvaytg.wintools;

import me.adasdead.WTools.wCore;

@SuppressWarnings("unused")
public class WinTools {

    private WinTools() {
        throw new AssertionError("No instances allowed");
    }

    public static boolean isWindowsOS() {
        return wCore.isWindowsOS();
    }

}