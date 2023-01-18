package entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @Column(name = "player_name", length = 45)
    private String playerName;

    @Size(max = 45)
    @Column(name = "player_email", length = 45)
    private String playerEmail;

    @Size(max = 45)
    @Column(name = "player_phone", length = 45)
    private int playerPhonenumber;

    @Size(max = 45)
    @Column(name = "player_status", length = 45)
    private String playerStatus;

    public Player(){}

    public Player(String playerName, String playerEmail, int playerPhonenumber, String playerStatus) {
        this.playerName = playerName;
        this.playerEmail = playerEmail;
        this.playerPhonenumber = playerPhonenumber;
        this.playerStatus = playerStatus;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String ownerName) {
        this.playerName = ownerName;
    }

    public String getPlayerEmail() {
        return playerEmail;
    }

    public void setPlayerEmail(String playerEmail) {
        this.playerEmail = playerEmail;
    }

    public int getPlayerPhonenumber() {
        return playerPhonenumber;
    }

    public void setPlayerPhonenumber(int playerPhonenumber) {
        this.playerPhonenumber = playerPhonenumber;
    }

    public String getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(String playerStatus) {
        this.playerStatus = playerStatus;
    }

}