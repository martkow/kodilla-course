package com.kodilla.stream.mirror;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MirrorStrings {
    public static String mirrorString(String s) {
        String mirrorString = "";

        for (int i = 0; i < s.length(); i++) {
            mirrorString += s.charAt(s.length() - i - 1);
        }
        return mirrorString;
    }

    public static String mirrorStringStream(String s) {
        return IntStream.range(0, s.length())
                .mapToObj(index -> String.valueOf(s.charAt(s.length() - index -1)))
                .collect(Collectors.joining());
    }

    public static String mirrorStringBuilder(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
