package me.adasdead.WTools;

import ru.kvaytg.wintools.annotation.Unstable;

@SuppressWarnings("unused")
@Unstable("Not tested for functionality.")
public class wMessageBox {
	
    private static final String BUTTON1_NAME = "OK";
    private static final String BUTTON2_NAME = "Cancel";
    private Type type;
    private String title;
    private String text;
    private String def;
    private String button1;
    private String button2;
    
    private static native void rawAlert(String p0, String p1, String p2);
    
    private static native int rawConfirm(String p0, String p1, String p2, String p3);
    
    private static native String rawPrompt(String p0, String p1, String p2, String p3, String p4);
    
    public static void alert(String s, String s2, String s3) {
        rawAlert(s, s2, s3);
    }
    
    public static int confirm(String s, String s2, String[] array) {
        if (array.length != 2) {
            return -1;
        }
        return rawConfirm(s, s2, array[0], array[1]);
    }
    
    public static String prompt(String s, String s2, String s3, String[] array) {
        if (array.length != 2) {
            return "";
        }
        return rawPrompt(s, s2, s3, array[0], array[1]);
    }
    
    private wMessageBox() {
        this.title = "";
        this.text = "";
        this.def = "";
        this.button1 = "";
        this.button2 = "";
    }
    
    public wMessageBox(Type type) {
        this.title = "";
        this.text = "";
        this.def = "";
        this.button1 = "";
        this.button2 = "";
        this.type = type;
    }
    
    public Type getType() {
        return this.type;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public void setButton1(String button1) {
        this.button1 = button1;
    }
    
    public void setButton2(String button2) {
        this.button2 = button2;
    }
    
    public void setDefault(String def) {
        this.def = def;
    }
    
    public String show() {
        if (this.type != Type.DEFAULT) {
            return rawPrompt(this.text, this.title, this.def, this.button1, this.button2);
        }
        if (this.button2.isEmpty()) {
            rawAlert(this.text, this.title, this.button1);
            return "OK";
        }
        if (rawConfirm(this.text, this.title, this.button1, this.button2) == 0) {
            return "OK";
        }
        return "Cancel";
    }
    
    static {
        wCore.loadLibrary();
    }
    
    public enum Type {
        DEFAULT, 
        PROMPT
    }

}