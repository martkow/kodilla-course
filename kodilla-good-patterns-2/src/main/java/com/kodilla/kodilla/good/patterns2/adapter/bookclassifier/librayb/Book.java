package com.kodilla.kodilla.good.patterns2.adapter.bookclassifier.librayb;

public class Book {
    private final String author;
    private final String title;
    private final int yearOfPublication;

    public Book(final String author, final String title, final int yearOfPublication) {
        this.author = author;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

}
