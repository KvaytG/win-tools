package ru.kvaytg.wintools;

import me.adasdead.WTools.wCore;
import ru.kvaytg.wintools.annotation.Description;

@SuppressWarnings("unused")
@Description(description = "Responsible for checking availability")
public class WinTools {

    private WinTools() {}

    public static boolean isWindows() {
        return wCore.isWindows();
    }

}