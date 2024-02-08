//Napisz program, który z podanego ciągu znaków znajdzie same samogłoski.
//Na przykład dla napisu “Adam” zwróci tylko “Aa”.
//Kluczowy algorytm zamknij w osobnej funkcji/metodzie, która będzie przyjmowała 1 argument wejściowy.
//Funkcja ta nie powinna wypisać niczego na ekran.
package com.kodilla.testing.taskmodulesixone;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdditionalTaskModuleSixOne {

    private final static Set<Character> vowelsSet = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));

    public static StringBuilder getVowels(String s) {
        StringBuilder sWithVowelsOnly = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (vowelsSet.contains(s.toLowerCase().charAt(i))) {
                sWithVowelsOnly.append(s.charAt(i));
            }
        }

        return sWithVowelsOnly;
    }
}

