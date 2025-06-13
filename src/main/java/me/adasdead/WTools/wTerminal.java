package me.adasdead.WTools;

import ru.kvaytg.wintools.annotation.Unstable;

@Unstable
public final class wTerminal {
	
    private wTerminal() {
        throw new AssertionError("No instances allowed");
    }
    
    public static native void write(String p0);
    
    public static native void writeLine(String p0);

    public static native void setOutColor(short p0);
    
    public static native void resetColor();
    
    static {
        wCore.loadLibrary();
    }

}