package entities;

import dtos.GuideDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Guide {
    @Id
    @Column(name = "idGuide", nullable = false)
    private Integer id;

    @Size(max = 45)
    @Column(name = "Gender", length = 45)
    private String gender;

    @Size(max = 45)
    @Column(name = "Birth_year", length = 45)
    private String birthYear;

    @Size(max = 45)
    @Column(name = "Profile", length = 45)
    private String profile;

    @Size(max = 45)
    @Column(name = "Image_Url", length = 45)
    private String imageUrl;

   /* @OneToMany(mappedBy = "fkidGuide")
    private List<Trip> trips = new ArrayList<>();

    */

    public Guide() {
    }

    public Guide(String gender, String birthYear, String profile, String imageUrl, List<Trip> trips) {
        this.gender = gender;
        this.birthYear = birthYear;
        this.profile = profile;
        this.imageUrl = imageUrl;
        //this.trips = trips;
    }

    /*
    public Guide(GuideDTO guideDTO){
        this.birthYear = guideDTO.getBirthYear();
        this.gender = guideDTO.getGender();
        this.profile = guideDTO.getProfile();
        this.trips = guideDTO.getTrips();
    }
     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

   /* public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    */

}