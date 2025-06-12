package ru.kvaytg.wintools;

import me.adasdead.WTools.wTerminal;

@SuppressWarnings("unused")
public class WinTerminal {

    private WinTerminal() {
        throw new AssertionError("No instances allowed");
    }

    public static void setColor(Colors color) {
        wTerminal.setOutColor(color);
    }

    public static void resetColors() {
        wTerminal.resetColor();
    }

    public static void write(String str) {
        wTerminal.write(str);
    }

    public static void writeLine(String str) {
        wTerminal.writeLine(str);
    }

    public static void write(String str, Colors color) {
        setColor(color);
        write(str);
        resetColors();
    }

    public static void writeLine(String str, Colors color) {
        setColor(color);
        writeLine(str);
        resetColors();
    }

}