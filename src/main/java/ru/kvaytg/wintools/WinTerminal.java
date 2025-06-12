package ru.kvaytg.wintools;

import me.adasdead.WTools.wTerminal;

@SuppressWarnings("unused")
public class WinTerminal {

    private WinTerminal() {}

    public static void write(String str) {
        wTerminal.write(str);
    }

    public static void writeLine(String str) {
        wTerminal.writeLine(str);
    }

    public static void setColor(Colors color) {
        wTerminal.setOutColor(color);
    }

    public static void resetColors() {
        wTerminal.resetColor();
    }

}