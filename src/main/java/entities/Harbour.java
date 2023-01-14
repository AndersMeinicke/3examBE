package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Harbour")
public class Harbour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_harbour", nullable = false)
    private int idHarbour;


    @Basic(optional = false)
    @NotNull
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @NotNull
    @Column(name = "address")
    private String address;

    @Basic(optional = false)
    @NotNull
    @Column(name = "capacity")
    private int capacity;


    public int getIdHarbour() {
        return idHarbour;
    }

    public void setIdHarbour(int idHarbour) {
        this.idHarbour = idHarbour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
