package dtos;

import entities.Match;
import entities.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayerDTO implements Serializable {
    private Integer id;
    private String playerName;
    private String playerEmail;
    private int playerPhonenumber;
    private String playerStatus;

    public PlayerDTO(Integer id, String playerName, String playerEmail, int playerPhonenumber, String playerStatus) {
        this.id = id;
        this.playerName = playerName;
        this.playerEmail = playerEmail;
        this.playerPhonenumber = playerPhonenumber;
        this.playerStatus = playerStatus;
    }

    public PlayerDTO(Player player) {
        this.id = player.getId();
        this.playerName = player.getPlayerName();
        this.playerEmail = player.getPlayerEmail();
        this.playerPhonenumber = player.getPlayerPhonenumber();
        this.playerStatus = player.getPlayerStatus();
    }

    public String getplayerName() {
        return playerName;
    }

    public String getPlayerEmail() {
        return playerEmail;
    }

    public int getPlayerPhonenumber() {
        return playerPhonenumber;
    }

    public String getPlayerStatus() {
        return playerStatus;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerDTO entity = (PlayerDTO) o;
        return Objects.equals(this.playerName, entity.playerName) &&
                Objects.equals(this.playerEmail, entity.playerEmail) &&
                Objects.equals(this.playerPhonenumber, entity.playerPhonenumber) &&
                Objects.equals(this.playerStatus, entity.playerStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, playerEmail, playerPhonenumber, playerStatus);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "playerName = " + playerName + ", " +
                "playerEmail = " + playerEmail + ", " +
                "playerPhonenumber = " + playerPhonenumber + ", " +
                "playerStatus = " + playerStatus + ")";
    }
    public static List<PlayerDTO> getPlayerDTOs(List<Player> players) {
        List<PlayerDTO> playerDTOList = new ArrayList<>();
        players.forEach(player -> {
            playerDTOList.add(new PlayerDTO(player));
        });
        return playerDTOList;


    }
}
