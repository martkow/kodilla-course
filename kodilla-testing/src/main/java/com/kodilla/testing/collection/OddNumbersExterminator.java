package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OddNumbersExterminator {
    public List<Integer> exterminate(List<Integer> numbers) {
        List<Integer> onlyEvenNumbers = new ArrayList<>();

        for (Integer i : numbers) {
            if (i % 2 == 0) {
                onlyEvenNumbers.add(i);
            }
        }

        return onlyEvenNumbers;
    }
}
