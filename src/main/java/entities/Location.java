package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @Column(name = "address", nullable = false, length = 45)
    private String address;

    @Size(max = 45)
    @Column(name = "city", nullable = false, length = 45)
    private String city;
    @Size(max = 45)
    @Column(name = "conditions", nullable = false, length = 45)
    private String conditions;

    public Location(String address, String city, String conditions) {
        this.address = address;
        this.city = city;
        this.conditions = conditions;
    }

    public Location() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }
}