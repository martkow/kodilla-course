package com.kodilla.transaltor;

import java.util.HashMap;
import java.util.Map;

public class Translator {
    private static final Map<String, String> MORSE_CODE_DICT = new HashMap<>();

    static {
        MORSE_CODE_DICT.put("·−", "A");
        MORSE_CODE_DICT.put("-···", "B");
        MORSE_CODE_DICT.put("-·-·", "C");
        MORSE_CODE_DICT.put("-··", "D");
        MORSE_CODE_DICT.put("·", "E");
        MORSE_CODE_DICT.put("··-·", "F");
        MORSE_CODE_DICT.put("--·", "G");
        MORSE_CODE_DICT.put("····", "H");
        MORSE_CODE_DICT.put("··", "I");
        MORSE_CODE_DICT.put("·---", "J");
        MORSE_CODE_DICT.put("-·-", "K");
        MORSE_CODE_DICT.put("·-··", "L");
        MORSE_CODE_DICT.put("--", "M");
        MORSE_CODE_DICT.put("-·", "N");
        MORSE_CODE_DICT.put("---", "O");
        MORSE_CODE_DICT.put("·--·", "P");
        MORSE_CODE_DICT.put("--·-", "Q");
        MORSE_CODE_DICT.put("·-·", "R");
        MORSE_CODE_DICT.put("···", "S");
        MORSE_CODE_DICT.put("-", "T");
        MORSE_CODE_DICT.put("··-", "U");
        MORSE_CODE_DICT.put("···-", "V");
        MORSE_CODE_DICT.put("·--", "W");
        MORSE_CODE_DICT.put("-··-", "X");
        MORSE_CODE_DICT.put("-·--", "Y");
        MORSE_CODE_DICT.put("--··", "Z");
        MORSE_CODE_DICT.put("-----", "0");
        MORSE_CODE_DICT.put("·----", "1");
        MORSE_CODE_DICT.put("··---", "2");
        MORSE_CODE_DICT.put("···--", "3");
        MORSE_CODE_DICT.put("····-", "4");
        MORSE_CODE_DICT.put("·····", "5");
        MORSE_CODE_DICT.put("-····", "6");
        MORSE_CODE_DICT.put("--···", "7");
        MORSE_CODE_DICT.put("---··", "8");
        MORSE_CODE_DICT.put("----·", "9");
    }

    public static String translateMorseCode(String code) {
        StringBuilder translatedText = new StringBuilder();

        String[] words = code.trim().split("   "); // Split words (3 spaces)

        for (String word : words) {
            String[] letters = word.split(" "); // Split letters in a word (1 space)
            for (String letter : letters) {
                String translatedLetter = MORSE_CODE_DICT.get(letter);
                if (translatedLetter != null) {
                    translatedText.append(translatedLetter);
                } else {
                    translatedText.append("?"); // If letter is unknown
                }
            }
            translatedText.append(" "); // Add space between words
        }

        return translatedText.toString().trim();
    }
}
