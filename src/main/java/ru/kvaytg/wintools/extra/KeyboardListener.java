package ru.kvaytg.wintools.extra;

/**
 * Listener interface for receiving global keyboard events.
 * * <p>The class that is interested in processing a keyboard event
 * implements this interface, and the object created with that class
 * is registered with {@link WinToolsExtra#addKeyboardListener(KeyboardListener)}.</p>
 *
 * @author KvaytG
 * @since 1.1.0
 */
@FunctionalInterface
public interface KeyboardListener {

    /**
     * Invoked when a physical key is pressed down.
     * * <p>This method receives a Virtual-Key (VK) code. These codes are consistent
     * across different keyboard layouts and represent the physical key on the board.</p>
     * * @param vkCode The virtual-key code of the pressed key (e.g., 0x20 for SPACE, 0x0D for ENTER).
     * @see <a href="https://learn.microsoft.com/en-us/windows/win32/inputdev/virtual-key-codes">Windows Virtual-Key Codes</a>
     */
    void onKeyPress(int vkCode);

}