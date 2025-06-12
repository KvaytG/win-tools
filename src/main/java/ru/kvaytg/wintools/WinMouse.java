package ru.kvaytg.wintools;

import me.adasdead.WTools.wMouse;
import me.adasdead.WTools.wMouse.Button;

@SuppressWarnings("unused")
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