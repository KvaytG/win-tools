package ru.kvaytg.wintools.api;

import me.adasdead.WTools.wMessageBox;

@SuppressWarnings("unused")
public class WinMessageBox {

    /**
     * Private constructor to prevent instantiation.
     */
    private WinMessageBox() {
        throw new AssertionError("No instances allowed");
    }

    /**
     * Displays a simple alert dialog with a single button.
     *
     * @param text   The message to display in the dialog.
     * @param title  The title of the dialog window.
     * @param button The label of the button (e.g., "OK").
     */
    public static void alert(String text, String title, String button) {
        wMessageBox.rawAlert(text, title, button);
    }

    /**
     * Displays a confirmation dialog with two buttons.
     *
     * @param text    The message to display in the dialog.
     * @param title   The title of the dialog window.
     * @param buttons An array of exactly two button labels: [button1, button2].
     * @return 0 if the first button is clicked, 1 if the second button is clicked
     *         or if the dialog is closed via the window close button.
     *         Returns -1 if the buttons array does not contain exactly two elements.
     */
    public static int confirm(String text, String title, String[] buttons) {
        if (buttons.length != 2) {
            return -1;
        }
        return wMessageBox.rawConfirm(text, title, buttons[0], buttons[1]);
    }

    /**
     * Displays a prompt dialog with an input field and two buttons.
     *
     * @param text    The message to display in the dialog.
     * @param title   The title of the dialog window.
     * @param def     The default value in the input field.
     * @param buttons An array of exactly two button labels: [button1, button2].
     * @return The text entered by the user if the first button is clicked,
     *         or an empty string if the second button is clicked or the dialog is closed.
     *         Returns an empty string if the buttons array does not contain exactly two elements.
     */
    public static String prompt(String text, String title, String def, String[] buttons) {
        if (buttons.length != 2) {
            return "";
        }
        return wMessageBox.rawPrompt(text, title, def, buttons[0], buttons[1]);
    }

}