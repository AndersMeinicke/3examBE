package entities;

import dtos.TripDTO;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Trip {
    @Id
    @Column(name = "idTrip", nullable = false)
    private Integer id;

    @Size(max = 45)
    @Column(name = "Date", length = 45)
    private String date;

    @Size(max = 45)
    @Column(name = "Time", length = 45)
    private String time;

    @Size(max = 45)
    @Column(name = "Location", length = 45)
    private String location;

    @Size(max = 45)
    @Column(name = "Duration", length = 45)
    private String duration;

    @Size(max = 45)
    @Column(name = "Packing_list", length = 45)
    private String packingList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fkidGuide")
    private Guide fkidGuide;

    public Trip() {
    }

    public Trip(String date, String time, String location, String duration, String packingList, Guide fkidGuide) {
        this.date = date;
        this.time = time;
        this.location = location;
        this.duration = duration;
        this.packingList = packingList;
        this.fkidGuide = fkidGuide;
    }

    /*public Trip(TripDTO tripDTO){
        this.date = tripDTO.getDate();
        this.time = tripDTO.getTime();
        this.location = tripDTO.getLocation();
        this.duration = tripDTO.getDuration();
        this.packingList = tripDTO.getPackingList();
        this.fkidGuide = tripDTO.getFkidGuide();
    }
     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPackingList() {
        return packingList;
    }

    public void setPackingList(String packingList) {
        this.packingList = packingList;
    }

    public Guide getFkidGuide() {
        return fkidGuide;
    }

    public void setFkidGuide(Guide fkidGuide) {
        this.fkidGuide = fkidGuide;
    }

}