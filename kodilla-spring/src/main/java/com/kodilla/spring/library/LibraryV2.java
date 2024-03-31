package com.kodilla.spring.library;

import java.util.ArrayList;
import java.util.List;

public final class LibraryV2 {
    private final List<String> books = new ArrayList<>();
    private LibraryV2DbController libraryV2DbController;

    public LibraryV2(LibraryV2DbController libraryV2DbController) {
        this.libraryV2DbController = libraryV2DbController;
    }

    public LibraryV2() {
    }

    public void saveToDb() {
        libraryV2DbController.saveData();
    }

    public void loadFromDb() {
        libraryV2DbController.loadData();
    }
}
