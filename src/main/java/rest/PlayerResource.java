package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.MatchDTO;
import dtos.PlayerDTO;
import dtos.PlayerMatchesDTO;
import entities.Match;
import entities.Player;
import entities.PlayerMatches;
import errorhandling.API_Exception;
import facades.PlayerFacade;
import javassist.NotFoundException;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("player")
public class PlayerResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final PlayerFacade FACADE = PlayerFacade.getplayerFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() throws NotFoundException {
        return Response.ok().entity(GSON.toJson(FACADE.getAllplayers())).build();
    }

    @POST
    @Path("/create")
    @Produces({MediaType.APPLICATION_JSON})
    public Response create(String player) {
        Player player1 =GSON.fromJson(player, Player.class);
        Player burner = new Player(player1.getPlayerName(),player1.getPlayerEmail(),player1.getPlayerPhonenumber(),player1.getPlayerStatus());
        Player newPlayer = FACADE.createplayer(burner);
        return Response.ok().entity(GSON.toJson(newPlayer)).build();
    }
    @GET
    @Path("/get+{name}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response getByName(@PathParam("name") String name ) throws API_Exception {
        PlayerDTO playerDTO = FACADE.getPlayerByName(name);
        return Response.ok().entity(GSON.toJson(playerDTO)).build();
    }
    @POST
    @Path("/{player}+{match}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response createPlayerMatch(@PathParam("player") int player, @PathParam("match") int match) {
        PlayerMatches playerMatches = new PlayerMatches(player,match);
        PlayerMatches burner = new PlayerMatches(playerMatches.getPlayerID(), playerMatches.getMatchID());
        PlayerMatches newPlayermatch = FACADE.createPlayerMatches(burner);
        return Response.ok().entity(GSON.toJson(newPlayermatch)).build();
    }
    @GET
    @Path("/allmatches+{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response getAllplayermatchesFromid(@PathParam("id") int id){
        List<PlayerMatchesDTO> playerMatchesDTOList = FACADE.getPlayerMatchesFromID(id);
        return Response.ok().entity(GSON.toJson(playerMatchesDTOList)).build();
    }
    @PUT
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response editPlayer(@PathParam("id") int id, String player)throws EntityNotFoundException {
        Player player1 =  GSON.fromJson(player, Player.class);
        PlayerDTO playerDTO = FACADE.UpdatePlayer(id,player1);
        return Response.ok().entity(GSON.toJson(playerDTO)).build();
    }

}
