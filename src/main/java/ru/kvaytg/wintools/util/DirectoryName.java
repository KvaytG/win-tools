package ru.kvaytg.wintools.util;

import ru.kvaytg.wintools.api.WinTools;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jetbrains.annotations.ApiStatus.Internal;

/**
 * INTERNAL! Do not use directly.
 * Generates hashed directory name for WinTools internal needs.
 *
 * @apiNote This class is not part of the public API.
 * @implNote Implementation may change or be removed without notice.
 */
@Internal
public final class DirectoryName {

    private static final String NAME;

    private DirectoryName() {
        throw new AssertionError("No instances allowed");
    }

    static {
        String username = System.getProperty("user.name", "unknown");
        NAME = WinTools.NAME + "_" + hashString(username);
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
            throw new IllegalStateException("SHA-256 algorithm is unavailable", ex);
        }
    }

}