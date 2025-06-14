package ru.kvaytg.wintools.util;

import ru.kvaytg.wintools.annotation.Internal;
import ru.kvaytg.wintools.api.WinTools;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Utility methods intended for internal use only.
 *
 * @apiNote This class is not part of the public API. Use at your own risk.
 */
@Internal
public final class DirectoryName {

    private static final String NAME;

    static {
        String username = System.getProperty("user.name");
        NAME = WinTools.NAME + "_" + hashString(username);
    }

    private DirectoryName() {
        throw new AssertionError("No instances allowed");
    }

    public static String get() {
        return NAME;
    }

    private static String hashString(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException("SHA-256 algorithm is unavailable", ex);
        }
    }

}