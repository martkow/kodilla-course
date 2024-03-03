package rps.game;

import rps.player.Player;

import java.util.*;

public class Game {
    private final static String NAME = "ROCK-PAPER-SCISSORS";
    public GameSettings gameSettings;
    private List<Round> rounds = new ArrayList<>();
    private Map<Player, Integer> winCounts = new HashMap<>();

    public Game(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }

    public void play() {
        if (!isGameWon()) {
            Round round = new Round(rounds.size() + 1);
            rounds.add(round);
            round.playRound(gameSettings.getPlayers());

            round.getRoundWinner().ifPresent(p -> winCounts.merge(p, 1, Integer::sum));
        } else {
            finishGame();
        }
    }

    public boolean isGameWon() {
        Optional<Integer> max = winCounts.entrySet().stream()
                .map(Map.Entry::getValue)
                .max(Comparator.naturalOrder());
        return gameSettings.getRoundsNumberToWinGame() <= max.orElse(0) ;
    }

    private void finishGame() {
        Messages.printWinMessage(getWinner(), winCounts);
    }

    private Player getWinner() {
        return winCounts.entrySet().stream()
                .filter(e -> e.getValue() == gameSettings.getRoundsNumberToWinGame())
                .map(Map.Entry::getKey)
                .findAny().get();
    }

    public void restartGame() {
       rounds = new ArrayList<>();
       winCounts = new HashMap<>();

    }
}
