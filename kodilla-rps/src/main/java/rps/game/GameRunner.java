package rps.game;

import java.util.Scanner;

public class GameRunner {
    private final static Scanner scanner = new Scanner(System.in);

    public static void start() {
        Game game = new Game(new GameSettings());

        boolean end = false;
        while (!end) {
            Messages.printInstructionMessage();
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("X")) {
                Messages.printQuestionQuitMessage();
                if (scanner.nextLine().equalsIgnoreCase("Y")) break;
            } else if (input.equalsIgnoreCase("N")) {
                Messages.printQuestionRestartMessage();
                if (scanner.nextLine().equalsIgnoreCase("Y")) {
                    game.restartGame();
                }
            }
            end = game.isGameWon();
            game.play();
        }
    }
}
