package ru.kvaytg.wintools;

import me.adasdead.WTools.wNotifications;
import ru.kvaytg.wintools.annotation.Description;

@SuppressWarnings("unused")
@Description(description = "Responsible for sending notifications")
public class WinNotifications {

	private WinNotifications() {}
	
	public static void sendNotification(final String text, final String title) {
		wNotifications.notify(text, title);
	}

}