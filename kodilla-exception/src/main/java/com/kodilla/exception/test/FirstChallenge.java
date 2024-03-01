package com.kodilla.exception.test;

public class FirstChallenge {
    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    public int power(int a, int b) {
        if (a == 0 && b == 0) {
            throw new ArithmeticException();
        } else if (a == 0) {
            return 0;
        } else if (b == 0) {
            return 1;
        } else {
            int p = a;
            for (int i = 1; i < b; i++) {
                p *= a;
            }
            return p;
        }
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        try {
            double result = firstChallenge.divide(3, 0);
            System.out.println(result);
        } catch (ArithmeticException ae) {
            System.out.println("Division by zero. Error: " + ae);
        } finally {
            System.out.println("Division End");
        }

        try {
            int result = firstChallenge.power(0, 0);
            System.out.println(result);
        } catch (ArithmeticException ae) {
            System.out.println("Indeterminate symbol. Error: " + ae);
        } finally {
            System.out.println("Exponentiation End");
        }
    }
}
