package me.adasdead.WTools;

public class wNotifications {
	
    private wNotifications() {}
    
    public static native void notify(String p0, String p1);
    
    static {
        wCore.loadLibrary();
    }
    
}