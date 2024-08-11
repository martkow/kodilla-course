package com.kodilla.kodilla.good.patterns2.adapter.bookclassifier.libraya;

import java.util.Set;

public interface Classifier {
    int publicationYearMedian(Set<Book> bookSet);
}
