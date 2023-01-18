package dtos;

import entities.PlayerMatches;

import java.io.Serializable;
import java.util.Objects;

public class PlayerMatchesDTO implements Serializable {
    private final Integer id;
    private final int playerID;
    private final int matchID;

    public PlayerMatchesDTO(Integer id, int playerID, int matchID) {
        this.id = id;
        this.playerID = playerID;
        this.matchID = matchID;
    }
    public PlayerMatchesDTO(PlayerMatches p){
        this.id = p.getId();
        this.playerID = p.getPlayerID();
        this.matchID = p.getMatchID();
    }

    public Integer getId() {
        return id;
    }

    public int getPlayerID() {
        return playerID;
    }

    public int getMatchID() {
        return matchID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerMatchesDTO entity = (PlayerMatchesDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.playerID, entity.playerID) &&
                Objects.equals(this.matchID, entity.matchID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playerID, matchID);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "playerID = " + playerID + ", " +
                "matchID = " + matchID + ")";
    }
}
