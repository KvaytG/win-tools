package me.adasdead.WTools;

import ru.kvaytg.wintools.annotation.Unstable;

@Unstable
public final class wNotifications {
	
    private wNotifications() {
        throw new AssertionError("No instances allowed");
    }
    
    public static native void notify(String p0, String p1);
    
    static {
        wCore.loadLibrary();
    }
    
}