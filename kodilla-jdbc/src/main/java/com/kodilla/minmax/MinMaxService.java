package com.kodilla.minmax;

import java.util.Collection;

public class MinMaxService {
    public static Integer getMin(Collection<Integer> collection) {
        if (collection.isEmpty()) {
            return null;
        }

        int min = Integer.MAX_VALUE;
        for (Integer i : collection) {
            if (i <= min) {
                min = i;
            }
        }
        return min;
    }

    public static Integer getMax(Collection<Integer> collection) {
        if (collection.isEmpty()) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        for (Integer i : collection) {
            if (i >= max) {
                max = i;
            }
        }
        return max;
    }
}
