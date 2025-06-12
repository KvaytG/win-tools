package ru.kvaytg.wintools;

import me.adasdead.WTools.wNotifications;

@SuppressWarnings("unused")
public class WinNotifications {

	private WinNotifications() {}
	
	public static void sendNotification(final String text, final String title) {
		wNotifications.notify(text, title);
	}

}