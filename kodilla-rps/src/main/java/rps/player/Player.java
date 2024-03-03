package rps.player;

import java.util.Objects;

public class Player {
    private static int idCounter = 0;
    private int playerId;
    private String playerName;
    private boolean isSystemPlayer;

    public Player(String playerName, boolean isSystemPlayer) {
        this.playerId = ++idCounter;
        this.playerName = playerName;
        this.isSystemPlayer = isSystemPlayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerId == player.playerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId);
    }

    public String getPlayerName() {
        return playerName;
    }

    public boolean isSystemPlayer() {
        return isSystemPlayer;
    }

    @Override
    public String toString() {
        return playerName;
    }
}
