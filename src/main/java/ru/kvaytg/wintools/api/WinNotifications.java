package ru.kvaytg.wintools.api;

import me.adasdead.WTools.wNotifications;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public final class WinNotifications {

	private WinNotifications() {
		throw new AssertionError("No instances allowed");
	}
	
	public static void send(@NotNull String text, @NotNull String title) {
		wNotifications.notify(text, title);
	}

}