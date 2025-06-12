package me.adasdead.WTools;

import ru.kvaytg.wintools.Colors;

public class wTerminal {
	
    private wTerminal() {}
    
    public static native void write(final String p0);
    
    public static native void writeLine(final String p0);

    @Deprecated
    public static native void setOutColor(final short p0);
    
    public static native void resetColor();

    public static void setOutColor(final Colors color) {
        setOutColor(color.getColor());
    }
    
    static {
        wCore.loadLibrary();
    }

}