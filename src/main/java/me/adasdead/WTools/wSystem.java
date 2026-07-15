package me.adasdead.WTools;

import ru.kvaytg.wintools.annotation.Unstable;

@Unstable
public final class wSystem {
	
    private wSystem() {
        throw new AssertionError("No instances allowed");
    }
    
    public static native void reboot();
    
    public static native void shutdown();
    
    public static native void _bsod(long p0);
    
    static {
        wCore.loadLibrary();
    }

}