package entities;

import javax.persistence.*;

@Entity
public class PlayerMatches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playermatch_id", nullable = false)
    private Integer id;
    @Column(name = "player_id", length = 45)
    private int playerID;
    @Column(name = "match_id", length = 45)
    private int matchID;

    public PlayerMatches(){}
    public PlayerMatches(int playerID, int matchID) {
        this.playerID = playerID;
        this.matchID = matchID;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public int getMatchID() {
        return matchID;
    }

    public void setMatchID(int matchID) {
        this.matchID = matchID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
