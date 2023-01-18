package dtos;

import entities.Location;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LocationDTO implements Serializable {
    private String city;
    private String address;
    private String condition;

    public LocationDTO(String city, String address, String condtion) {
        this.city = city;
        this.address = address;
        this.condition = condtion;
    }

    public LocationDTO(Location location) {
        this.address = location.getAddress();
        this.city = location.getCity();
        this.condition = location.getConditions();
    }

    public static List<LocationDTO> getLocationDTOs(List<Location> locations) {
        List<LocationDTO> locationDTOList = new ArrayList<>();
        locations.forEach(location -> {
            locationDTOList.add(new LocationDTO(location));
        });
        return locationDTOList;


    }

    public String getCity() {
        return city;
    }

    public String getAdress() {
        return address;
    }

    public String getCondition() {
        return condition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, city, condition);
    }

    @Override
    public String toString() {
        return "LocationDTO{" +
                "city='" + city + '\'' +
                ", adress='" + address + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }
}
