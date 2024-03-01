package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.io.FileReaderWithoutHandling;

import java.io.IOException;

public class ExceptionModuleRunner {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();

        try {
            fileReader.readFile();
        } catch (FileReaderException fre) {
            System.out.println("Exception for readFile(): " + fre);
        }

        try {
            fileReader.readFile("name.txt");
        } catch (FileReaderException fre) {
            System.out.println("Exception for readFile(fileName): " + fre);
        }

        FileReaderWithoutHandling fileReaderWithoutHandling = new FileReaderWithoutHandling();
        try {
            fileReaderWithoutHandling.readFile();
        } catch (IOException e) {
            System.out.println("Upps. Error: " + e);
        }
    }
}
