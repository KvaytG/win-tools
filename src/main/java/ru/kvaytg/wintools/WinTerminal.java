package ru.kvaytg.wintools;

import me.adasdead.WTools.wTerminal;
import ru.kvaytg.wintools.annotation.Description;

@SuppressWarnings("unused")
@Description(description = "Responsible for managing the console")
public class WinTerminal {

    private WinTerminal() {}

    public static void write(final String str) {
        wTerminal.write(str);
    }

    public static void writeLine(final String str) {
        wTerminal.writeLine(str);
    }

    public static void setColor(final Colors color) {
        wTerminal.setOutColor(color);
    }

    public static void resetColors() {
        wTerminal.resetColor();
    }

}