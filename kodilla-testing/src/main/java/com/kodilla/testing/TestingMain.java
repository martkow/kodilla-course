package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Moduł 6. Wprowadzenie do testowania oprogramowania");
// 6.1 Additional task - vowels
        System.out.println(AdditionalTaskModuleSixOne.getVowels("Adam"));
// 6.2 Example - unit test
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUserName();

        if (result.equals("theForumUser")) {
            System.out.println("Test OK");
        } else {
            System.out.println("ERROR");
        }
// 6.2 First unit test
        int a = 0;
        int b = 10;

        if (Calculator.add(a, b) == a + b) {
            System.out.println("Test OK");
        } else {
            System.out.println("ERROR");
        }

        if (Calculator.subtract(a, b) == a - b) {
            System.out.println("Test OK");
        } else  {
            System.out.println("ERROR");
        }
    }
}
