package facades;

import dtos.PlayerMatchesDTO;
import dtos.PlayerDTO;
import entities.PlayerMatches;
import entities.Player;
import errorhandling.API_Exception;
import javassist.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class PlayerFacade {
        private static EntityManagerFactory emf;
        private static PlayerFacade instance;

        private PlayerFacade() {
        }
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static PlayerFacade getplayerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PlayerFacade();
        }
        return instance;
    }
    public Player createplayer(Player player){
            EntityManager em = getEntityManager();
            try {
            em.getTransaction().begin();
            em.persist(player);
            em.getTransaction().commit();
            }finally {
                em.close();
            }
    return player;
    }
    public List<PlayerDTO> getAllplayers() throws NotFoundException {
            EntityManager em = getEntityManager();
            try {
                TypedQuery<Player> query = em.createQuery("SELECT p FROM Player p", Player.class);
                if (query == null) {
                    throw new NotFoundException("No player");
                }
                List<Player> playerList = query.getResultList();
                for (Player p: playerList
                     ) {
                    System.out.println(p.getPlayerEmail());
                }
                return PlayerDTO.getPlayerDTOs(playerList);
            }finally {
                em.close();
            }
    }
    public PlayerDTO getPlayerByName(String name) throws API_Exception{
            EntityManager em = getEntityManager();
            PlayerDTO playerDTO = null;
            try {
                TypedQuery<Player> query = em.createQuery("SELECT p FROM Player p WHERE p.playerName = ?1", Player.class)
                        .setParameter(1,name);
                List<Player> playerList = query.getResultList();
                for (Player p:playerList
                     ) {
                    playerDTO = new PlayerDTO(p);
                }
                return playerDTO;
            }finally {
                em.close();
            }
    }
    public PlayerMatches createPlayerMatches(PlayerMatches playerMatches){
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(playerMatches);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
        return playerMatches;
    }
    public List<PlayerMatchesDTO> getPlayerMatchesFromID(int id){
            EntityManager em = getEntityManager();
            List<PlayerMatchesDTO>playerMatchesDTOList = new ArrayList<>();
            try {
                TypedQuery<PlayerMatches> query = em.createQuery("SELECT p FROM PlayerMatches p WHERE p.playerID = ?1", PlayerMatches.class)
                        .setParameter(1,id);
                List<PlayerMatches> playerMatches = query.getResultList();
                for (PlayerMatches p: playerMatches
                     ) {
                    System.out.println("HELLO" + p.getPlayerID()+ " " + p.getId());
                    PlayerMatchesDTO playerMatchesDTO = new PlayerMatchesDTO(p);
                    System.out.println("HELLO AGAIN " + playerMatchesDTO.getId()+ " " + playerMatchesDTO.getPlayerID() + " " + playerMatchesDTO.getMatchID());
                    playerMatchesDTOList.add(playerMatchesDTO);
                }
                return playerMatchesDTOList;
            }finally {
                em.close();
            }
    }
    public PlayerDTO UpdatePlayer(int id, Player playerUpdate){
        EntityManager em = getEntityManager();
        Player player;
        try {
            player = em.find(Player.class, id);
            em.getTransaction().begin();
            player.setPlayerEmail(playerUpdate.getPlayerEmail());
            player.setPlayerName(playerUpdate.getPlayerName());
            player.setPlayerPhonenumber(playerUpdate.getPlayerPhonenumber());
            player.setPlayerStatus(playerUpdate.getPlayerStatus());
            em.getTransaction().commit();
            return new PlayerDTO(player);
        } finally {
            em.close();
        }
    }

}
