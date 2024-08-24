package com.kodilla.translator;

import com.kodilla.transaltor.Translator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for Translator class")
public class TranslatorTests {
    @Test
    void shouldReturnWordTranslation() {
        // Given
        String code = "··· --- ···";
        // When
        String result = Translator.translateMorseCode(code);
        // Then
        Assertions.assertEquals("SOS", result);
    }

    @Test
    void shouldReturnTwoWordsTranslation() {
        // Given
        String code = "···· · ·-·· ·-·· ---   -··· ··- -··· ··-";
        // When
        String result = Translator.translateMorseCode(code);
        // Then
        Assertions.assertEquals("HELLO BUBU", result);
    }

    @Test
    void shouldReturnUnknownLetter() {
        // Given
        String code = "-··· ··- -··· ··- $";
        // When
        String result = Translator.translateMorseCode(code);
        // Then
        Assertions.assertEquals("BUBU?", result);
    }
}
