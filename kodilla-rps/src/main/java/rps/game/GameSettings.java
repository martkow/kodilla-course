package rps.game;

import rps.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameSettings {
    private static final Scanner scanner = new Scanner(System.in);
    private int roundsNumberWonToWinGame;
    private List<Player> players = new ArrayList<>();

    public int getRoundsNumberToWinGame() {
        return roundsNumberWonToWinGame;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public  GameSettings() {
        Messages.printWelcomeMessage();
        Messages.printEnterNameMessage();
        players.add(new Player("System", true));
        players.add(new Player(scanner.nextLine().substring(0,10), false));

        boolean numberOfWonRoundsSet = false;
        while (!numberOfWonRoundsSet) {
            try {
                Messages.printSetNumberOfWonRoundsMessage();
                roundsNumberWonToWinGame = scanner.nextInt();
                if (roundsNumberWonToWinGame > 0) {
                    break;
                } else {
                    Messages.printWrongDataMessage();
                }
            } catch (Exception e) {
                Messages.printWrongDataMessage();
                scanner.nextLine();
            }
        }
    }
}
