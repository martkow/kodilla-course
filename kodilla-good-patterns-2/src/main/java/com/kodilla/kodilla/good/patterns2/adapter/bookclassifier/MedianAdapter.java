package com.kodilla.kodilla.good.patterns2.adapter.bookclassifier;

import com.kodilla.kodilla.good.patterns2.adapter.bookclassifier.libraya.Book;
import com.kodilla.kodilla.good.patterns2.adapter.bookclassifier.libraya.Classifier;
import com.kodilla.kodilla.good.patterns2.adapter.bookclassifier.librayb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        Map<BookSignature, com.kodilla.kodilla.good.patterns2.adapter.bookclassifier.librayb.Book> books = new HashMap<>();

        bookSet.stream()
                .forEach(b ->
                    books.put(
                            new BookSignature(b.getSignature()),
                            new com.kodilla.kodilla.good.patterns2.adapter.bookclassifier.librayb.Book(
                                    b.getAuthor(),
                                    b.getTitle(),
                                    b.getPublicationYear()))
                );

        return medianPublicationYear(books);
    }
}
