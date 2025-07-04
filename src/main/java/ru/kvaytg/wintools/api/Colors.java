package ru.kvaytg.wintools.api;

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

    Colors(int number) {
        this.color = (short) number;
    }

    public short getColor() {
        return color;
    }

}