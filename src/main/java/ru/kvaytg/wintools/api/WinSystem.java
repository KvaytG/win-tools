package ru.kvaytg.wintools.api;

import me.adasdead.WTools.wSystem;
import ru.kvaytg.wintools.annotation.Dangerous;

@SuppressWarnings("unused")
public final class WinSystem {

	private WinSystem() {
		throw new AssertionError("No instances allowed");
	}
	
	public static void shutdown() {
		wSystem.shutdown();
	}
	
	public static void reboot() {
		wSystem.reboot();
	}

	/**
	 * Triggers a Blue Screen of Death
	 * Dangerous operation!
	 * @throws SecurityException if dangerous operations are disabled
	 */
	@Dangerous("Causes BSOD. May harm the system.")
	public static void bsod() {
		if (!WinTools.isDangerOpsEnabled()) {
			throw new SecurityException("Dangerous operations are disabled");
		}
		wSystem._bsod(-1073741790L);
	}
	
}