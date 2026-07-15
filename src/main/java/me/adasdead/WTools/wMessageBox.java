package me.adasdead.WTools;

import ru.kvaytg.wintools.annotation.Unstable;

@Unstable
public final class wMessageBox {

    private wMessageBox() {
        throw new AssertionError("No instances allowed");
    }

    public static native void rawAlert(String text, String title, String button);

    public static native int rawConfirm(String text, String title, String button1, String button2);

    public static native String rawPrompt(String text, String title, String def, String button1, String button2);

    static {
        wCore.loadLibrary();
    }

}