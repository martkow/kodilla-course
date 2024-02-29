package com.kodilla.stream.mirror;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for MirrorStrings class")
public class MirrorStringsTestSuite {
    @DisplayName("Test case for mirrorString method")
    @Test
    void testCaseForMirrorStringMethodForEmptyString() {
        // Given
        String s = "";
        // When
        String reversedS = MirrorStrings.mirrorString(s);
        // Then
        Assertions.assertEquals("", reversedS);
    }

    @DisplayName("Test case for mirrorString method")
    @Test
    void testCaseForMirrorStringMethodForNonemptyString() {
        // Given
        String s = "Bubu";
        // When
        String reversedS = MirrorStrings.mirrorString(s);
        // Then
        Assertions.assertEquals("ubuB", reversedS);
    }
}
