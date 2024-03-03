package rps.game;

import rps.player.Player;

import java.util.Map;

public class Messages {
    private static final String welcomeMessage = """
                ************************************************************
                                    ROCK-PAPER-SCISSORS
                ************************************************************
            """;
    private static final String enterNameMessage = """
            Enter your name:            
            """;

    private static final String setNumberOfWonRoundsMessage = """
            Set the number of rounds won to win the game. Enter number:
            """;

    private static final String wrongDataMessage = """
            Wrong type of data passed!
            """;

    private static final String winMessage = "The winner is... ";

    private static final String questionQuitGameMessage = "Are your sure you want to quit? [Y/N]:";

    private static final String questionRestartGameMessage = "Are your sure you want to restart the game? [Y/N]:";

    private static final String roundNumberMessage = "Round no. ";

    private static final String instructionMessage = "Use keyboard [X->Quit, N->Restart, P->Play]. Select key:";

    private static final String enterMoveMessage = "Choose your move [1->ROCK, 2->PAPER, 3->SCISSORS]:";

    public static void printWelcomeMessage() {
        System.out.print(welcomeMessage);
    }

    public static void printEnterNameMessage() {
        System.out.print(enterNameMessage);
    }

    public static void printSetNumberOfWonRoundsMessage() {
        System.out.print(setNumberOfWonRoundsMessage);
    }

    public static void printWrongDataMessage() {
        System.out.print(wrongDataMessage);
    }

    public static void printWinMessage(Player player, Map<Player, Integer> winCounts) {
        System.out.printf("********************** End of the game *********************************************************\n");
        System.out.println(winMessage + player.getPlayerName());
    }

    public static void printQuestionQuitMessage() {
        System.out.println(questionQuitGameMessage);
    }

    public static void printQuestionRestartMessage() {
        System.out.println(questionRestartGameMessage);
    }

    public static void printRoundNumberMessage(int roundNumber) {
        System.out.printf("********************** %s %d ************************************************************\n",roundNumberMessage, roundNumber);
    }

    public static void printInstructionMessage() {
        System.out.println(instructionMessage);
    }

    public static void printEnterMoveMessage() {
        System.out.println(enterMoveMessage);
    }
}
