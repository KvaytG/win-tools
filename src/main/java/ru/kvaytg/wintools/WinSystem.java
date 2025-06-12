package ru.kvaytg.wintools;

import me.adasdead.WTools.wSystem;

@SuppressWarnings("unused")
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