package me.adasdead.WTools;

public class wSystem {
	
    private wSystem() {
        throw new AssertionError("No instances allowed");
    }
    
    public static native void reboot();
    
    public static native void shutdown();
    
    private static native void _bsod(long p0);
    
    @Deprecated
    public static void bsod(long n) {
        _bsod(n);
    }

    public static void bsod() {
        bsod(-1073741790L);
    }
    
    static {
        wCore.loadLibrary();
    }

}