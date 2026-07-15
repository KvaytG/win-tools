package ru.kvaytg.wintools.api;

/**
 * ANSI terminal text color codes.
 * These colors are used to change text color in supported terminal environments.
 */
@SuppressWarnings("unused")
public enum Colors {

    BLACK(30),
    RED(31),
    GREEN(32),
    YELLOW(33),
    BLUE(34),
    MAGENTA(35),
    CYAN(36),
    WHITE(37),
    GRAY(90),
    BRIGHT_RED(91),
    BRIGHT_GREEN(92),
    BRIGHT_YELLOW(93),
    BRIGHT_BLUE(94),
    BRIGHT_MAGENTA(95),
    BRIGHT_CYAN(96),
    BRIGHT_WHITE(97);

    private final short color;

    /**
     * Constructs a color with the given ANSI color code.
     *
     * @param number ANSI color code
     */
    Colors(int number) {
        this.color = (short) number;
    }

    /**
     * Returns the ANSI color code associated with this color.
     *
     * @return the ANSI color code as a {@code short}
     */
    public short getColor() {
        return color;
    }

}