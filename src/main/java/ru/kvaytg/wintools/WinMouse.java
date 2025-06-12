package ru.kvaytg.wintools;

import me.adasdead.WTools.wMouse;
import me.adasdead.WTools.wMouse.Button;
import ru.kvaytg.wintools.annotation.Description;

@SuppressWarnings("unused")
@Description(description = "Responsible for controlling the mouse")
public class WinMouse {

	private WinMouse() {}
	
	public static void setCursorPosition(Position position) {
		wMouse.setPosition(position);
	}

	public static Position getCursorPosition() {
		return wMouse.getPosition();
	}
	
	public static void leftClick() {
		wMouse.click(Button.LEFT);
	}
	
	public static void rightClick() {
		wMouse.click(Button.RIGHT);
	}
	
}