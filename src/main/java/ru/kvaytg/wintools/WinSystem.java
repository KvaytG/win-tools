package ru.kvaytg.wintools;

import me.adasdead.WTools.wSystem;
import ru.kvaytg.wintools.annotation.Dangerous;

@SuppressWarnings("unused")
public class WinSystem {

	private WinSystem() {}
	
	public static void shutdown() {
		wSystem.shutdown();
	}
	
	public static void reboot() {
		wSystem.reboot();
	}

	@Dangerous("Causes BSOD. May harm the system.")
	public static void bsod() {
		wSystem.bsod();
	}
	
}