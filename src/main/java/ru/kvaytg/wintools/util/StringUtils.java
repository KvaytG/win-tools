package ru.kvaytg.wintools.util;

public final class StringUtils {

    private StringUtils() {
        throw new AssertionError("No instances allowed");
    }

    private static boolean regionMatchesIgnoreCase(String str, int start, String search, int length) {
        return str.regionMatches(true, start, search, 0, length);
    }

    public static boolean containsIgnoreCase(String str, String searchStr) {
        if (str == null || searchStr == null || searchStr.length() > str.length()) {
            return false;
        }
        int len = searchStr.length();
        int max = str.length() - len;
        for (int i = 0; i <= max; i++) {
            if (regionMatchesIgnoreCase(str, i, searchStr, len)) {
                return true;
            }
        }
        return false;
    }

}