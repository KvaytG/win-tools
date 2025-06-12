package ru.kvaytg.wintools;

import me.adasdead.WTools.wNotifications;

@SuppressWarnings("unused")
public class WinNotifications {

	private WinNotifications() {}
	
	public static void sendNotification(String text, String title) {
		wNotifications.notify(text, title);
	}

}