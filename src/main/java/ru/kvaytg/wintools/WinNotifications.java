package ru.kvaytg.wintools;

import me.adasdead.WTools.wNotifications;

@SuppressWarnings("unused")
public class WinNotifications {

	private WinNotifications() {
		throw new AssertionError("No instances allowed");
	}
	
	public static void send(String text, String title) {
		wNotifications.notify(text, title);
	}

}