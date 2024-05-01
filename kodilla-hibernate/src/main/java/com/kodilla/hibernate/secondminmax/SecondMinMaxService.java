package com.kodilla.hibernate.secondminmax;

import com.kodilla.minmax.MinMaxService;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class SecondMinMaxService {
    public static Integer getSecondMin(Collection<Integer> collection) {
        if (collection.isEmpty()) {
            return null;
        }

        Integer min = MinMaxService.getMin(collection);
        collection.removeAll(List.of(min));
        Integer secondMin = MinMaxService.getMin(collection);

        return secondMin;

    }

    public static Integer getSecondMax(Collection<Integer> collection) {
        if (collection.isEmpty() || new HashSet<>(collection).size() < 2) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (Integer i : collection) {
            if (i > max) {
                secondMax = max;
                max = i;
            } else if (i > secondMax && i != max) {
                secondMax = i;
            }
        }

        return secondMax;
    }
}
