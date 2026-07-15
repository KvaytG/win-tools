package ru.kvaytg.wintools.api;

import me.adasdead.WTools.wTerminal;
import org.jetbrains.annotations.NotNull;

/**
 * Utility class for interacting with the Windows terminal using the WTools library.
 */
@SuppressWarnings("unused")
public final class WinTerminal {

    /**
     * Private constructor to prevent instantiation.
     */
    private WinTerminal() {
        throw new AssertionError("No instances allowed");
    }

    /**
     * Sets the terminal output color.
     *
     * @param color the {@link Colors} enum representing the desired color
     */
    public static void setColor(@NotNull Colors color) {
        wTerminal.setOutColor(color.getColor());
    }

    /**
     * Resets the terminal output color to default.
     */
    public static void resetColor() {
        wTerminal.resetColor();
    }

    /**
     * Writes a string to the terminal without a newline.
     *
     * @param str the string to write
     */
    public static void write(@NotNull String str) {
        wTerminal.write(str);
    }

    /**
     * Writes a string to the terminal followed by a newline.
     *
     * @param str the string to write
     */
    public static void writeLine(@NotNull String str) {
        wTerminal.writeLine(str);
    }

    /**
     * Writes a string to the terminal in the specified color without a newline.
     *
     * @param str   the string to write
     * @param color the color to use
     */
    public static void write(@NotNull String str, @NotNull Colors color) {
        setColor(color);
        write(str);
    }

    /**
     * Writes a string to the terminal in the specified color followed by a newline.
     *
     * @param str   the string to write
     * @param color the color to use
     */
    public static void writeLine(@NotNull String str, @NotNull Colors color) {
        setColor(color);
        writeLine(str);
    }

}