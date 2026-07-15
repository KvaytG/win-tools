package me.adasdead.WTools;

import ru.kvaytg.wintools.annotation.Unstable;

@Unstable
public final class wMouse {
	
    private wMouse() {
        throw new AssertionError("No instances allowed");
    }
    
    public static native void click(short p0);
    
    public static native int[] _getPosition();

    public static native void setPosition(int p0, int p1);
    
    static {
        wCore.loadLibrary();
    }

}