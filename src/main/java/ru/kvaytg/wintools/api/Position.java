package ru.kvaytg.wintools.api;

/**
 * Immutable 2D coordinate representing a position on the screen.
 */
public class Position {

    private final int x;
    private final int y;

    /**
     * Creates a new {@code Position} with the specified coordinates.
     *
     * @param x the X coordinate
     * @param y the Y coordinate
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the X coordinate.
     *
     * @return the X value
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the Y coordinate.
     *
     * @return the Y value
     */
    public int getY() {
        return y;
    }

    /**
     * Returns a string representation of the position.
     *
     * @return a string in the format {@code Position{x=..., y=...}}
     */
    @Override
    public String toString() {
        return "Position{x=" + x + ", y=" + y + "}";
    }

}