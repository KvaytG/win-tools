package ru.kvaytg.wintools.api;

import me.adasdead.WTools.wNotifications;
import org.jetbrains.annotations.NotNull;

/**
 * Utility class for sending Windows notifications using the WTools library.
 */
@SuppressWarnings("unused")
public final class WinNotifications {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private WinNotifications() {
		throw new AssertionError("No instances allowed");
	}

	/**
	 * Sends a system notification with the given text and title.
	 *
	 * @param text  the message body of the notification
	 * @param title the title of the notification
	 */
	public static void send(@NotNull String text, @NotNull String title) {
		wNotifications.notify(text, title);
	}

}