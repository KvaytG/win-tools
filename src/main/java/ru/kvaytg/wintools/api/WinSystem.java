package ru.kvaytg.wintools.api;

import me.adasdead.WTools.wSystem;
import ru.kvaytg.wintools.annotation.Dangerous;

/**
 * Utility class for performing system-level operations in Windows
 */
@SuppressWarnings("unused")
public final class WinSystem {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private WinSystem() {
		throw new AssertionError("No instances allowed");
	}

	/**
	 * Shuts down the system.
	 */
	public static void shutdown() {
		wSystem.shutdown();
	}

	/**
	 * Reboots the system.
	 */
	public static void reboot() {
		wSystem.reboot();
	}

	/**
	 * Triggers a Blue Screen of Death (BSOD).
	 *
	 * This method forcibly crashes the system and should only be used for
	 * research or testing in a secure environment.
	 *
	 * Never use in production!
	 *
	 * This action violates the Microsoft EULA
	 * and may cause data loss or hardware damage.
	 *
	 * @throws SecurityException if dangerous operations are disabled via {@link WinTools#isDangerOpsEnabled()}
	 */
	@Dangerous("Causes BSOD. May harm the system.")
	public static void bsod() {
		if (!WinTools.isDangerOpsEnabled()) {
			throw new SecurityException("Dangerous operations are disabled");
		}
		wSystem._bsod(-1073741790L);
	}

}