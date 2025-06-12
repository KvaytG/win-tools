package ru.kvaytg.wintools;

import me.adasdead.WTools.wSystem;
import ru.kvaytg.wintools.annotation.Description;

@SuppressWarnings("unused")
@Description(description = "Responsible for system management")
public class WinSystem {

	private WinSystem() {}
	
	public static void shutdown() {
		wSystem.shutdown();
	}
	
	public static void reboot() {
		wSystem.reboot();
	}
	
	public static void bsod() {
		wSystem.bsod();
	}
	
}