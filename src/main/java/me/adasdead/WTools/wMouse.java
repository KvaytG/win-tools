package me.adasdead.WTools;

import ru.kvaytg.wintools.Position;

public class wMouse {
	
    private wMouse() {
        throw new AssertionError("No instances allowed");
    }
    
    private static native void click(short p0);
    
    private static native int[] _getPosition();
    
    @Deprecated
    public static native void setPosition(int p0, int p1);
    
    public static void click(Button button) {
        if (button == Button.LEFT) {
            click((short) 1);
        }
        if (button == Button.RIGHT) {
            click((short) 0);
        }
    }
    
    public static Position getPosition() {
        int[] getPosition = _getPosition();
        return new Position(getPosition[0], getPosition[1]);
    }
    
    public static void setPosition(Position position) {
        setPosition(position.getX(), position.getY());
    }
    
    static {
        wCore.loadLibrary();
    }
    
    public enum Button {
        LEFT, 
        RIGHT
    }

}