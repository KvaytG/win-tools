# win-tools

![Java 8](https://img.shields.io/badge/Java-8-orange?logo=java) ![Native DLL](https://img.shields.io/badge/Native%20DLL-Windows-lightgrey?logo=windows) ![MIT License](https://img.shields.io/badge/License-MIT-green) [![Sponsor](https://img.shields.io/badge/Sponsor-%E2%9D%A4-red)](https://kvaytg.ru/donate.php?lang=en)

A collection of Java utilities for interacting with Windows via native DLLs.

## ✨ Features
- **Native interactions**: Direct access to Windows API via Java wrappers
- **Input control**: Precise mouse manipulation (clicks, cursor positioning)
- **System notifications**: Windows toast notifications delivery
- **Console operations**: Color-formatted output
- **System operations**: Shutdown/reboot + low-level functions
- **Static API**: Utility classes with instantiation prevention
- **Native integration**: Optimized pre-built DLL components

## 📚 Usage
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

## ⚙️ Installation
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
*Optional:* To use a specific version, tag a release and replace `-SNAPSHOT` with the tag name.

## ❗ Important Notes
- Performance has been tested only on Windows 10 and Windows 11.
- Administrator privileges are NOT required.
- Dangerous operations are disabled by default and require explicit activation.

## ⚠️ Dangerous Operations
Functions marked with `@Dangerous`, intended only for:
- Security research
- System stability testing
- Educational purposes

## 🙏 Acknowledgments
Special thanks to **adasdead** for developing the native DLL components that made this project possible.

## 📜 License
Licensed under the **[MIT](LICENSE.txt)** license.

This project uses open-source components. For license details see **[pom.xml](pom.xml)** and dependencies' official websites.
