package com.kodilla.kodilla.good.patterns2.adapter.bookclassifier;

import com.kodilla.kodilla.good.patterns2.adapter.bookclassifier.librayb.Book;
import com.kodilla.kodilla.good.patterns2.adapter.bookclassifier.librayb.BookSignature;
import com.kodilla.kodilla.good.patterns2.adapter.bookclassifier.librayb.BookStatistics;
import com.kodilla.kodilla.good.patterns2.adapter.bookclassifier.librayb.Statistics;

import java.util.Map;

public class MedianAdaptee implements BookStatistics {
    private final Statistics statistics = new Statistics();

    @Override
    public int averagePublicationYear(Map<BookSignature, Book> books) {
        return statistics.averagePublicationYear(books);
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, Book> books) {
        return statistics.medianPublicationYear(books);
    }
}
