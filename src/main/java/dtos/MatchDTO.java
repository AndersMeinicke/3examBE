package dtos;

import entities.Match;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MatchDTO implements Serializable {
    private int id;
    private String opponentTeam;
    private String judge;
    private String type;
    private boolean inDoors;
    private int locationID;

    public MatchDTO(int id, String opponentTeam, String judge, String type, boolean inDoors, int locationID) {
        this.id = id;
        this.opponentTeam = opponentTeam;
        this.judge = judge;
        this.type = type;
        this.inDoors = inDoors;
        this.locationID = locationID;
    }

    public MatchDTO(Match match) {
        this.id = match.getId();
        this.opponentTeam = match.getOpponentTeam();
        this.judge = match.getJudge();
        this.type = match.getType();
        this.inDoors = match.isInDoors();
        this.locationID = match.getLocationID();
    }

    public static List<MatchDTO> getMatchDTOs(List<Match> matches) {
        List<MatchDTO> matchDTOList = new ArrayList<>();
        matches.forEach(match -> {
            matchDTOList.add(new MatchDTO(match));
        });
        return matchDTOList;


    }

    public String getOpponentTeam() {
        return opponentTeam;
    }

    public void setOpponentTeam(String opponentTeam) {
        this.opponentTeam = opponentTeam;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isInDoors() {
        return inDoors;
    }

    public void setInDoors(boolean inDoors) {
        this.inDoors = inDoors;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
