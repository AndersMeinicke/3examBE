package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "Owner.deleAllRows", query = "Delete from Owner")
@Table(name = "Owner")
public class Owner {


    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "idOwner", nullable = false)
    private int id;

    @NotNull
    @Column(name = "name")
    private String Ownername;


    @Basic(optional = false)
    @NotNull
    @Column(name = "address")
    private String Address;

    @Basic(optional = false)
    @NotNull
    @Column(name = "phone")
    private int phoneNumber;

    @JoinTable(name = "Owner_Boat", joinColumns = {
            @JoinColumn(name = "idOwner", referencedColumnName = "idOwner")}, inverseJoinColumns = {
            @JoinColumn(name = "idBoat", referencedColumnName = "idBoat")})
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Boat> boatList = new ArrayList<>();





    public void addBoat( Boat ownerBoat){
        boatList.add(ownerBoat);
    }

    public String getOwnername() {
        return Ownername;
    }

    public void setOwnername(String ownername) {
        Ownername = ownername;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Boat> getBoatList() {
        return boatList;
    }

    public void setBoatList(List<Boat> boatList) {
        this.boatList = boatList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
