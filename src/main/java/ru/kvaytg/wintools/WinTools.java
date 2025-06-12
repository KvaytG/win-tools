package ru.kvaytg.wintools;

import me.adasdead.WTools.wCore;

@SuppressWarnings("unused")
public class WinTools {

    private WinTools() {}

    public static boolean isWindows() {
        return wCore.isWindows();
    }

}