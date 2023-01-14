package facades;

import dtos.BoatDTO;
import dtos.OwnerDTO;
import entities.Owner;
import javassist.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class OwnerFacade {
    private static EntityManagerFactory emf;
    private static OwnerFacade instance;


    private OwnerFacade(){
    }

    public static OwnerFacade getOwnerFacade(EntityManagerFactory _emf){
        if (instance == null){
            emf = _emf;
            instance = new OwnerFacade();
        }
        return instance;
    }
    private EntityManager getEntityManager(){ return emf.createEntityManager();}

    public Owner createOwner(Owner owner){
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(owner);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return owner;
    }

    public List<OwnerDTO> getAllOwners() throws NotFoundException{
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Owner> query = em.createQuery("SELECT o FROM Owner o", Owner.class);
            if (query == null){
                throw new NotFoundException("Can't find any owners)");
            }
            List<Owner> owners = query.getResultList();
            return OwnerDTO.getOwnerDTOs(owners);
        } finally {
            em.close();
        }
    }
}
