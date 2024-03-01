package com.kodilla.exception.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for FileReader class")
public class FileReaderTestSuite {
    @DisplayName("Test case for readFile method")
    @Test
    void testCaseForReadFileMethod() {
        // Given
        FileReader fileReader = new FileReader();
        // When & Then
        Assertions.assertDoesNotThrow(() -> fileReader.readFile());
        Assertions.assertThrows(FileReaderException.class, () -> fileReader.readFile("x.txt"));
        Assertions.assertAll(
                () -> Assertions.assertThrows(FileReaderException.class, () -> fileReader.readFile("x.txt")),
                () -> Assertions.assertThrows(FileReaderException.class, () -> fileReader.readFile(null)),
                () -> Assertions.assertDoesNotThrow(() -> fileReader.readFile("names.txt"))
        );
    }

}
