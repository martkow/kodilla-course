package rps.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name...");
        String name = scanner.nextLine();
        System.out.println("Player: " + name);

        boolean end = false;
        while(!end) {
            String b = scanner.nextLine();
            if (b.equals("x")) {
                end = true;
            }
        }
    }
}