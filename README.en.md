
# win-tools

![Java 8](https://img.shields.io/badge/Java-8-orange?logo=java) ![Native DLL](https://img.shields.io/badge/Native%20DLL-Windows-lightgrey?logo=windows) ![MIT License](https://img.shields.io/badge/License-MIT-green) [![Sponsor](https://img.shields.io/badge/Sponsor-%E2%9D%A4-red)](https://kvaytg.ru/donate.php?lang=en)

A collection of Java utilities for interacting with Windows via native DLLs.

## ✨ Features
- **Native interactions**: Direct access to Windows API via Java wrappers
- **Input control**: Precise mouse manipulation (clicks, cursor positioning)
- **System notifications**: Windows toast notifications delivery
- **Console operations**: Color-formatted output
- **System operations**: Shutdown/reboot + low-level functions
- **Message boxes**: Alert, confirm, and prompt dialogs via native Windows dialogs
- **Static API**: Utility classes with instantiation prevention
- **Native integration**: Optimized pre-built DLL components
- **Global Key Listening**: Intercept keyboard events system-wide

## 📚 Usage
### WinMessageBox Class
```java
// Simple alert dialog
WinMessageBox.alert("This is an alert message", "Alert", "OK");

// Confirmation dialog with two buttons
int result = WinMessageBox.confirm("Do you want to continue?", "Confirm", new String[]{"Yes", "No"});
if (result == 0) {
    // First button clicked
} else {
    // Second button clicked or dialog closed
}

// Prompt dialog with input field
String input = WinMessageBox.prompt("Enter your name:", "Prompt", "Default Name", new String[]{"OK", "Cancel"});
if (!input.isEmpty()) {
    // First button clicked with input
} else {
    // Second button clicked or dialog closed
}
```
### WinMouse Class
```java
// Left click
WinMouse.leftClick();

// Right click
WinMouse.rightClick();

// Set cursor position (X, Y)
WinMouse.setCursorPosition(100, 200);

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
// System shutdown
WinSystem.shutdown();

// System reboot
WinSystem.reboot();

// Trigger BSoD
// Dangerous operation, use with caution!
// Requires enabling via WinTools.setDangerOpsEnabled(true)
try {
    WinSystem.bsod();
} catch (SecurityException e) {
    // Throws if dangerous operations are disabled
}
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

// Enable/disable dangerous operations
WinTools.setDangerOpsEnabled(false);

// Check dangerous operations status
boolean enabled = WinTools.isDangerOpsEnabled();
```
### WinKeyboard Class
```java
// Add a global keyboard listener
WinKeyboard.addListener(vkCode -> {
    System.out.println("Key Pressed! VK Code: " + vkCode);
    // Example: Check for INSERT key (VK 45)
    if (vkCode == 45) {
        System.out.println("INSERT pressed");
    }
});

// Remove the listener when no longer needed
// WinKeyboard.removeListener(myListener);
```

## 📥 Installation (Maven)
1. Add the JitPack repository to your `pom.xml`
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
2. Add the dependency
```xml
<dependency>
    <groupId>com.github.KvaytG</groupId>
    <artifactId>win-tools</artifactId>
    <version>-SNAPSHOT</version>
</dependency>
```
Optional: to use a specific version, tag a release and replace `-SNAPSHOT` with the tag name.

## ❗ Important Notes
* Tested only on Windows 10 and Windows 11.
* Administrator privileges are NOT required.
* Dangerous operations are disabled by default and require explicit enabling.
* Functions marked with `@Dangerous` are intended only for:
    - Security research
    - System stability testing
    - Educational purposes

## 🙏 Acknowledgements
Special thanks to [**adasdead**](https://github.com/adasdead) for developing the original native DLL, which made the project possible.

## 📝 License
Licensed under the **[MIT](LICENSE.txt)** license.

This project uses open-source components. For license details see **[pom.xml](pom.xml)** and dependencies' official websites.
