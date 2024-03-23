package com.kodilla.good.patterns.challenges;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
    }

    // Zadanie 12.1.1: funkcyjna iteracja po tytułach
    // Wykorzystując Streamy, wykonaj iterację po mapie tytułów
    // i wyświetl wszystkie tytuły w jednym ciągu, separując je wykrzyknikiem:
    public static String concatMovies(Map<String, List<String>> movies) {
        return movies.entrySet()
                .stream()
                .flatMap(e -> e.getValue().stream())
                .collect(Collectors.joining("!"));
    }

    //Zadanie 12.1.2: Silnia też jest potężna
    // Zaimplementuj własnymi siłami algorytm, który obliczy wynik matematycznej silni dla podanej liczby (n).
    // Kluczowy algorytm zamknij w funkcji/metodzie, która wynik obliczeń powinna zwracać (nic nie wyświetlać).
    public static int factorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        int factorial = 1;
        for (int i = 1; i < n + 1; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
