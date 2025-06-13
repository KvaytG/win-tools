package ru.kvaytg.wintools;

import me.adasdead.WTools.wTerminal;

@SuppressWarnings("unused")
public final class WinTerminal {

    private WinTerminal() {
        throw new AssertionError("No instances allowed");
    }

    public static void setColor(Colors color) {
        wTerminal.setOutColor(color.getColor());
    }

    public static void resetColor() {
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
    }

    public static void writeLine(String str, Colors color) {
        setColor(color);
        writeLine(str);
    }

}