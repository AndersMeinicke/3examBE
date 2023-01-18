package facades;

import dtos.LocationDTO;
import dtos.MatchDTO;
import dtos.UserDTO;
import entities.Location;
import entities.Match;
import entities.User;
import errorhandling.API_Exception;
import javassist.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class LocationFacade {
    private static EntityManagerFactory emf;
    private static LocationFacade instance;

    private LocationFacade() {
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static LocationFacade getLocationFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new LocationFacade();
        }
        return instance;
    }

    public Location createLocation(Location location) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(location);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return location;
    }

    public List<LocationDTO> getAllLocations() throws NotFoundException {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Location> query = em.createQuery("SELECT l FROM Location l", Location.class);
            if (query == null) {
                throw new NotFoundException("No Location");
            }
            List<Location> locationList = query.getResultList();
            return LocationDTO.getLocationDTOs(locationList);
        } finally {
            em.close();
        }
    }

    public LocationDTO getLocationFromID(int id) throws API_Exception {
        EntityManager em = getEntityManager();

        Location location = em.find(Location.class, id);
        if (location == null)
            throw new API_Exception("There's no user with that id", 404);
        em.close();
        return new LocationDTO(location);
    }

    public LocationDTO updateLocation(int id, Location updatedLocation) {
        EntityManager em = getEntityManager();
        Location location;
        try {
            location = em.find(Location.class, id);
            em.getTransaction().begin();
            location.setAddress(updatedLocation.getAddress());
            location.setCity(updatedLocation.getCity());
            location.setConditions(updatedLocation.getConditions());
            em.getTransaction().commit();
            return new LocationDTO(location);
        } finally {
            em.close();
        }

    }
}
