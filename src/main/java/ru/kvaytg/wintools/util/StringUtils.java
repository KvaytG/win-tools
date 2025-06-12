package ru.kvaytg.wintools.util;

public class StringUtils {

    private StringUtils() {
        throw new AssertionError("No instances allowed");
    }

    private static boolean regionMatches(CharSequence cs,
                                         int thisStart,
                                         CharSequence substring,
                                         int length) {
        if (cs instanceof String && substring instanceof String) {
            return ((String)cs).regionMatches(true, thisStart, (String)substring, 0, length);
        } else {
            int index1 = thisStart;
            int index2 = 0;
            int tmpLen = length;
            int srcLen = cs.length() - thisStart;
            int otherLen = substring.length();
            if (thisStart >= 0 && length >= 0) {
                if (srcLen >= length && otherLen >= length) {
                    while(tmpLen-- > 0) {
                        char c1 = cs.charAt(index1++);
                        char c2 = substring.charAt(index2++);
                        if (c1 != c2) {
                            char u1 = Character.toUpperCase(c1);
                            char u2 = Character.toUpperCase(c2);
                            if (u1 != u2 && Character.toLowerCase(u1) != Character.toLowerCase(u2)) {
                                return false;
                            }
                        }
                    }
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public static boolean containsIgnoreCase(CharSequence str,
                                             CharSequence searchStr) {
        if (str != null && searchStr != null) {
            int len = searchStr.length();
            int max = str.length() - len;
            for(int i = 0; i <= max; ++i) {
                if (regionMatches(str, i, searchStr, len)) {
                    return true;
                }
            }
        }
        return false;
    }

}