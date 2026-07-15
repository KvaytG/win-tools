package ru.kvaytg.wintools.api;

import me.adasdead.WTools.wMouse;
import org.jetbrains.annotations.NotNull;

/**
 * Utility class for controlling the mouse in Windows using the WTools library.
 */
@SuppressWarnings("unused")
public final class WinMouse {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private WinMouse() {
		throw new AssertionError("No instances allowed");
	}

	/**
	 * Performs a left mouse click.
	 */
	public static void leftClick() {
		wMouse.click((short) 1);
	}

	/**
	 * Performs a right mouse click.
	 */
	public static void rightClick() {
		wMouse.click((short) 0);
	}

	/**
	 * Returns the current position of the mouse cursor.
	 *
	 * @return a {@link Position} object containing the cursor coordinates.
	 */
	public static Position getCursorPosition() {
		int[] getPosition = wMouse._getPosition();
		return new Position(getPosition[0], getPosition[1]);
	}

	/**
	 * Sets the mouse cursor to the specified screen coordinates.
	 *
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 */
	public static void setCursorPosition(int x, int y) {
		wMouse.setPosition(x, y);
	}

	/**
	 * Sets the mouse cursor to the position specified by a {@link Position} object.
	 *
	 * @param position the position to set the cursor to
	 */
	public static void setCursorPosition(@NotNull Position position) {
		setCursorPosition(position.getX(), position.getY());
	}

}