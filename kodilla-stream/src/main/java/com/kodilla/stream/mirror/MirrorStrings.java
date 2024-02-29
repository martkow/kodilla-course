package com.kodilla.stream.mirror;

public class MirrorStrings {
    public static String mirrorString(String s) {
        String mirrorString = "";

        for (int i = 0; i < s.length(); i++) {
            mirrorString += s.charAt(s.length() - i - 1);
        }
        return mirrorString;
    }
}
