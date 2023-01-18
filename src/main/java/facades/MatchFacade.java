package facades;

import dtos.LocationDTO;
import dtos.MatchDTO;
import dtos.UserDTO;
import entities.Location;
import entities.Match;
import entities.Role;
import entities.User;
import javassist.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.security.PublicKey;
import java.util.List;

public class MatchFacade {
        private static EntityManagerFactory emf;
        private static MatchFacade instance;

        private MatchFacade() {
        }
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static MatchFacade getmatchFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MatchFacade();
        }
        return instance;
    }
    public MatchDTO UpdateMatch(int id, Match matchUpdate){
        EntityManager em = getEntityManager();
        Match match;
        try {
            match = em.find(Match.class, id);
            em.getTransaction().begin();
            match.setOpponentTeam(matchUpdate.getOpponentTeam());
            match.setJudge(matchUpdate.getJudge());
            match.setType(matchUpdate.getType());
            match.setInDoors(matchUpdate.isInDoors());
            match.setLocationID(matchUpdate.getLocationID());
            em.getTransaction().commit();
            return new MatchDTO(match);
        } finally {
            em.close();
        }
    }
    public Match creatematch(Match match){
            EntityManager em = getEntityManager();
            try {
            em.getTransaction().begin();
            em.persist(match);
            em.getTransaction().commit();
            }finally {
                em.close();
            }
    return match;
    }
    public List<MatchDTO> getAllmatchs() throws NotFoundException {
            EntityManager em = getEntityManager();
            try {
                TypedQuery<Match> query = em.createQuery("SELECT m FROM Match m", Match.class);
                if (query == null) {
                    throw new NotFoundException("No match");
                }
                List<Match> matchList = query.getResultList();
                return MatchDTO.getMatchDTOs(matchList);
            }finally {
                em.close();
            }

    }
    public List<MatchDTO> getMatchesFromLocation(int id) throws  NotFoundException{
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Match> query = em.createQuery("SELECT m FROM Match m WHERE m.locationID = ?1", Match.class)
                    .setParameter(1,id);
            if (query == null) {
                throw new NotFoundException("No match");
            }
            List<Match> matchList = query.getResultList();
            return MatchDTO.getMatchDTOs(matchList);
        }finally {
            em.close();
        }
    }
    public MatchDTO deleteMatch(int id) throws NotFoundException{
        EntityManager em = getEntityManager();
        Match match;
        try {
            match = em.find(Match.class, id);
            em.getTransaction().begin();
            em.remove(match);
            em.getTransaction().commit();
            return new MatchDTO(match);
        }finally {
            em.close();
        }
    }
  /* public List<MatchDTO> useLocationName(String name) throws  NotFoundException{
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Location> query = em.createQuery("SELECT l FROM Location l WHERE l.city = ?1", Location.class)
                    .setParameter(1,name);
            if (query == null) {
                throw new NotFoundException("No match");
            }
            List<Location> locationsList = query.getResultList();

            for (Location l: locationsList
                 ) {
                i = l.getId();
            }


            int i = 1;
            em.close();
            List<MatchDTO> matchList = getMatchesFromLocation(i);
            return matchList;
        }finally {
            em.close();
        }
        */

    }

   /*
    public List<MatchDTO> getAllMatchesFromID(int id){
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Match> query = em.createQuery("SELECT m FROM Match m ", Match.class);
        }
        finally {
            em.close();
        }
    }*/


