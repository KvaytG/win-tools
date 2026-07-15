
# win-tools

[![US](https://kvaytg.ru/common/flags/us-21x16.svg) English](README.md) | ![RU](https://kvaytg.ru/common/flags/ru-21x16.svg) **Русский**

![Java 8](https://img.shields.io/badge/Java-8-orange?logo=java) ![Native DLL](https://img.shields.io/badge/Native%20DLL-Windows-lightgrey?logo=windows) ![PolyForm License](https://img.shields.io/badge/License-PolyForm-blue) [![Sponsor](https://img.shields.io/badge/Поддержать-%E2%9D%A4-red)](https://kvaytg.ru/donate.php?lang=ru)

Коллекция утилит на Java для взаимодействия с Windows через нативные DLL.

## ✨ Возможности
- **Нативное взаимодействие**: Прямой доступ к Windows API через обертки на Java
- **Управление вводом**: Точное управление мышью (клики, позиционирование курсора)
- **Управление клавиатуры**: Нажимайте отдельные клавиши и перехватывайте глобальные события с клавиатуры
- **Системные уведомления**: Отправка уведомлений Windows (toast)
- **Консольные операции**: Цветной вывод текста
- **Системные операции**: Выключение/перезагрузка + низкоуровневые функции
- **Окна сообщений**: Alert, confirm и prompt через нативные окна Windows
- **Статический API**: Классы-утилиты без возможности создания экземпляров
- **Нативная интеграция**: Оптимизированные предсобранные DLL

## 📚 Использование
### Класс WinMessageBox
```java
// Простое окно уведомления
WinMessageBox.alert("Это сообщение", "Уведомление", "OK");

// Окно подтверждения с двумя кнопками
int result = WinMessageBox.confirm("Продолжить?", "Подтверждение", new String[]{"Да", "Нет"});
if (result == 0) {
    // Нажата первая кнопка
} else {
    // Нажата вторая кнопка или закрыто окно
}

// Окно ввода с полем
String input = WinMessageBox.prompt("Введите ваше имя:", "Ввод", "Имя по умолчанию", new String[]{"OK", "Отмена"});
if (!input.isEmpty()) {
    // Нажата первая кнопка с введенным текстом
} else {
    // Нажата вторая кнопка или закрыто окно
}
```
### Класс WinMouse
```java
// Левый клик
WinMouse.leftClick();

// Правый клик
WinMouse.rightClick();

// Установить позицию курсора (X, Y)
WinMouse.setCursorPosition(100, 200);

// Получить текущую позицию курсора
Position pos = WinMouse.getCursorPosition();
```
### Класс WinNotifications
```java
// Отправка уведомления
WinNotifications.send("Текст сообщения", "Заголовок");
```
### Класс WinSystem
```java
// Выключение системы
WinSystem.shutdown();

// Перезагрузка системы
WinSystem.reboot();

// Вызов BSoD
// Опасная операция, использовать с осторожностью!
// Требует включения через WinTools.setDangerOpsEnabled(true)
try {
    WinSystem.bsod();
} catch (SecurityException e) {
    // Бросается, если опасные операции отключены
}
```
### Класс WinTerminal
```java
// Простой вывод
WinTerminal.write("Текст без перевода строки");
WinTerminal.writeLine("Текст с переводом строки");

// Цветной вывод
WinTerminal.write("Красный текст", Colors.RED);
WinTerminal.writeLine("Синий текст", Colors.BLUE);

// Сброс цвета
WinTerminal.resetColor();

// Установка постоянного цвета
WinTerminal.setColor(Colors.GREEN);
```
### Класс WinTools
```java
// Проверка ОС
if (WinTools.isWindows()) {
    // Логика для Windows
}

// Включение/отключение опасных операций
WinTools.setDangerOpsEnabled(false);

// Проверка статуса опасных операций
boolean enabled = WinTools.isDangerOpsEnabled();
```
### Класс WinKeyboard
```java
// Добавить глобальный слушатель клавиатуры
WinKeyboard.addListener(vkCode -> {
    System.out.println("Клавиша нажата! VK код: " + vkCode);
    // Пример: проверка клавиши INSERT (VK 45)
    if (vkCode == 45) {
        System.out.println("Нажата клавиша INSERT");
    }
});

// Удалите слушатель, когда он больше не нужен
// WinKeyboard.removeListener(myListener);

// Виртуальный код клавиши для 'A' = 0x41
// Зажать 'A'
WinKeyboard.pressKeyDown(0x41);
// Отпустить 'A'
WinKeyboard.pressKeyUp(0x41);
// Зажать и отпустить 'A'
WinKeyboard.pressKey(0x41);
```

## 📥 Установка (Maven)
1. Добавьте репозиторий JitPack в `pom.xml`
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
2. Добавьте зависимость
```xml
<dependency>
    <groupId>com.github.KvaytG</groupId>
    <artifactId>win-tools</artifactId>
    <version>-SNAPSHOT</version>
</dependency>
```
Необязательно: для конкретной версии используйте тег релиза вместо `-SNAPSHOT`.

## ❗ Важные замечания
* Работоспособность проверялась только на Windows 10 и Windows 11.
* Привилегии администратора НЕ требуются.
* Опасные операции по умолчанию отключены и требуют явного включения.
* Функции, помеченные `@Dangerous`, предназначены только для:
    - Исследований безопасности
    - Тестирования стабильности системы
    - Образовательных целей

## 🙏 Благодарности
Особая благодарность [**adasdead**](https://github.com/adasdead) за разработку оригинальной нативной DLL, благодаря которой проект стал возможен.

## 📝 Лицензия
Распространяется по лицензии **[PolyForm Noncommercial](LICENSE.md)**.

Проект использует компоненты с открытым исходным кодом. Сведения о лицензиях см. в **[pom.xml](pom.xml)** и на официальных ресурсах зависимостей.

