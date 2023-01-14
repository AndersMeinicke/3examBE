package entities;

import dtos.BoatDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "Boat")
public class Boat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idBoat", nullable = false)
    private int idBoat;

    @Basic(optional = false)
    @NotNull
    @Column(name = "brand")
    private String brand;

    @Basic(optional = false)
    @NotNull
    @Column(name = "make")
    private String make;

    @Basic(optional = false)
    @NotNull
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @NotNull
    @Column(name = "image")
    private String image;

    public Boat(){
    }

    public Boat(String brand, String make, String name, String image) {
        this.brand = brand;
        this.make = make;
        this.name = name;
        this.image = image;
    }
    public Boat(BoatDTO boatDTO){
        this.idBoat = boatDTO.getId();
        this.brand = boatDTO.getBrand();
        this.make = boatDTO.getMake();
        this.name = boatDTO.getName();
        this.image = boatDTO.getImage();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIdBoat() {
        return idBoat;
    }

    public void setIdBoat(int idBoat) {
        this.idBoat = idBoat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boat)) return false;
        Boat boat = (Boat) o;
        return getIdBoat() == boat.getIdBoat();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdBoat());
    }
}
