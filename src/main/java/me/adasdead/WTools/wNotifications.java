package me.adasdead.WTools;

public class wNotifications {
	
    private wNotifications() {}
    
    public static native void notify(final String p0, final String p1);
    
    static {
        wCore.loadLibrary();
    }
    
}