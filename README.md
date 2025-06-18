# WinTools
![Java](https://img.shields.io/badge/Java-8-blue?logo=java) ![DLL](https://img.shields.io/badge/Native_DLL-Windows-lightgrey)

**A collection of Java utilities for interacting with Windows via native DLLs**
## 📦 Features
- **Native interactions**: Direct access to Windows API via Java wrappers
- **Input control**: Precise mouse manipulation (clicks, cursor positioning)
- **System notifications**: Windows toast notifications delivery
- **Console operations**: Color-formatted output without ANSI codes
- **System operations**: Graceful shutdown/reboot + low-level functions
- **Static API**: Utility classes with instantiation prevention
- **Compatibility**: Legacy system support (Java 8)
- **Native integration**: Optimized pre-built DLL components
## 📚 API Documentation
### WinMouse Class
```java
// Left click
WinMouse.leftClick();

// Right click
WinMouse.rightClick();

// Set cursor position
WinMouse.setCursorPosition(new Position(100, 200));

// Get current position
Position pos = WinMouse.getCursorPosition();
```
### WinNotifications Class
```java
// Send notification
WinNotifications.send("Message text", "Title");
```
### WinSystem Class
```java
// Graceful shutdown
WinSystem.shutdown();

// System reboot
WinSystem.reboot();

// Triggers Blue Screen of Death
// Dangerous operation, use with caution!
// Requires enabling via WinTools.setDangerOpsEnabled(true)
WinSystem.bsod();
```
### WinTerminal Class
```java
// Basic output
WinTerminal.write("Text without newline");
WinTerminal.writeLine("Text with newline");

// Colored output
WinTerminal.write("Red text", Colors.RED);
WinTerminal.writeLine("Blue text", Colors.BLUE);

// Reset color
WinTerminal.resetColor();

// Set persistent color
WinTerminal.setColor(Colors.GREEN);
```
### WinTools Class
```java
// OS check
if (WinTools.isWindows()) {
    // Windows-specific logic
}

// Check danger operations status
boolean enabled = WinTools.isDangerOpsEnabled();

// Enable/disable danger operations
WinTools.setDangerOpsEnabled(false);
```
## ❗ Important Note
Functionality has only been tested on Windows 10 and Windows 11.

Dangerous operations are disabled by default and require explicit enabling.
## 🙏 Acknowledgments
Special thanks to **adasdead** for developing the native DLL components that made this project possible.
## 📜 License
WinTools is licensed under the **[MIT license](https://opensource.org/license/mit)**.