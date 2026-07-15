package ru.kvaytg.wintools.api;

/**
 * Listener interface for receiving global keyboard events.
 *
 * @author KvaytG
 * @since 2.0.0
 */
@FunctionalInterface
public interface KeyboardListener {

    /**
     * Invoked when a physical key is pressed down.
     *
     * @param vkCode The virtual-key code of the pressed key (e.g., 0x20 for SPACE).
     * @see <a href="https://learn.microsoft.com/en-us/windows/win32/inputdev/virtual-key-codes">Windows Virtual-Key Codes</a>
     */
    void onKeyPress(int vkCode);

}