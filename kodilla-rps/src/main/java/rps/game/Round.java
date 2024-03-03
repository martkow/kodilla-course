package rps.game;

import rps.player.Player;

import java.util.*;

public class Round {
    private static final Scanner scanner = new Scanner(System.in);
    private static int count = 0;
    private int roundId;
    private int roundNumber;
    private Map<Player, Moves> roundMoves = new HashMap<>();
    private Player roundWinner;

    public Round(int roundNumber) {
        this.roundId = ++count;
        this.roundNumber = roundNumber;
    }

    public void playRound(List<Player> players) {
        Messages.printRoundNumberMessage(roundNumber);
        for (Player p : players) {
            if (p.isSystemPlayer()) {
                roundMoves.put(p, generateRandomMove());
            } else {
                roundMoves.put(p, generateMove());
            }
        }
        roundWinner = getRoundWinner().isPresent() ? getRoundWinner().get() : null;
        printRoundSummary();
    }

    private Moves generateRandomMove() {
        return Moves.values()[new Random().nextInt(0,3)];
    }

    private Moves generateMove() {
        Messages.printEnterMoveMessage();
        return switch (scanner.nextLine()) {
            case "1" -> Moves.ROCK;
            case "2" -> Moves.PAPER;
            default -> Moves.SCISSORS;
        };
    }

    public Optional<Player> getRoundWinner() {
        // TODO -> Refactor this and compareMoves
        if (roundMoves.keySet().size() == 2) {
            List<Map.Entry<Player, Moves>> list = new ArrayList<>(roundMoves.entrySet());
            Optional<Moves> winnerMove = compareMoves(list.get(0).getValue(), list.get(1).getValue());
            if (winnerMove.isPresent()) {
                for (Map.Entry<Player, Moves> e : list) {
                    if (winnerMove.get().equals(e.getValue())) {
                        return Optional.of(e.getKey());
                    }
                }
            }
        }
        return Optional.empty();
    }

    private Optional<Moves> compareMoves(Moves move1, Moves move2) {
        if (move1.equals(move2)) {
            return Optional.empty();
        }
        if (move1.equals(Moves.PAPER) && move2.equals(Moves.SCISSORS) || move1.equals(Moves.SCISSORS) && move2.equals(Moves.PAPER)) {
            return Optional.of(Moves.SCISSORS);
        }
        if (move1.equals(Moves.PAPER) && move2.equals(Moves.ROCK) || move1.equals(Moves.ROCK) && move2.equals(Moves.PAPER)) {
            return Optional.of(Moves.PAPER);
        }
        return Optional.of(Moves.ROCK);
    }

    @Override
    public String toString() {
        return "Round Summary {round no. " + roundNumber + ", roundMoves=" + roundMoves + ", roundWinner=" + (roundWinner != null ? roundWinner : "No winner") + '}';
    }

    private void printRoundSummary(){
        System.out.printf("| %10s     | %10s     | %10s     |\n", "Player", "Move", "Winner");
        System.out.println("_ ".repeat(26));
        for (Map.Entry<Player, Moves> e : roundMoves.entrySet()) {
            System.out.printf("| %10s     | %10s     | %10s     |\n", e.getKey(), e.getValue(), (roundWinner == e.getKey() ? "\u2605" : ""));
        }
        System.out.println("************************************************************************************************");
    }
}
