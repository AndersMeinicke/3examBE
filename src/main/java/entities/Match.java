package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "matches")
public class Match implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @Column(name = "opponentTeam", length = 45)
    private String opponentTeam;

    @Size(max = 45)
    @Column(name = "judge", length = 45)
    private String judge;

    @Size(max = 45)
    @Column(name = "type", length = 45)
    private String type;

    @Size(max = 45)
    @NotNull
    @Column(name = "inDoors", nullable = false)
    private boolean inDoors;

    @NotNull
    @Column(name = "location_id", nullable = false)
    private int locationID;

    public Match(){}
    public Match(String opponentTeam, String judge, String type, boolean inDoors, int locationID) {
        this.opponentTeam = opponentTeam;
        this.judge = judge;
        this.type = type;
        this.inDoors = inDoors;
        this.locationID = locationID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}