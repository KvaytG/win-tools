package ru.kvaytg.wintools;

import me.adasdead.WTools.wTerminal;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public final class WinTerminal {

    private WinTerminal() {
        throw new AssertionError("No instances allowed");
    }

    public static void setColor(@NotNull Colors color) {
        wTerminal.setOutColor(color.getColor());
    }

    public static void resetColor() {
        wTerminal.resetColor();
    }

    public static void write(@NotNull String str) {
        wTerminal.write(str);
    }

    public static void writeLine(@NotNull String str) {
        wTerminal.writeLine(str);
    }

    public static void write(@NotNull String str, @NotNull Colors color) {
        setColor(color);
        write(str);
    }

    public static void writeLine(@NotNull String str, @NotNull Colors color) {
        setColor(color);
        writeLine(str);
    }

}