package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.MatchDTO;
import dtos.UserDTO;
import entities.Match;
import entities.Player;
import facades.MatchFacade;
import facades.UserFacade;
import javassist.NotFoundException;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("match")
public class MatchResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final MatchFacade FACADE = MatchFacade.getmatchFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() throws NotFoundException {
        return Response.ok().entity(GSON.toJson(FACADE.getAllmatchs())).build();
    }

    @GET
    @Path("/location+{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response getAllFromLocation(@PathParam("id") int id) throws NotFoundException {
        return Response.ok().entity(GSON.toJson(FACADE.getMatchesFromLocation(id))).build();
    }
    @PUT
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response editMatch(@PathParam("id") int id, String match)throws EntityNotFoundException {
        Match match1 =  GSON.fromJson(match, Match.class);
        MatchDTO matchDTO = FACADE.UpdateMatch(id,match1);
        return Response.ok().entity(GSON.toJson(matchDTO)).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response deleteMatch(@PathParam("id") int id) throws NotFoundException {
        return Response.ok().entity(GSON.toJson(FACADE.deleteMatch(id))).build();
    }

    @POST
    @Path("/create")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createMatch(String match) {

    Match match1 = GSON.fromJson(match, Match.class);
    Match burner = new Match(match1.getOpponentTeam(),match1.getJudge(),match1.getType(),match1.isInDoors(),match1.getLocationID());
    Match newMatch = FACADE.creatematch(burner);
        return Response.ok().entity(GSON.toJson(newMatch)).build();
}
 /*   @GET
    @Path("/location+{name}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response getAllFromLocationName(@PathParam("name") String name) throws NotFoundException{
        return Response.ok().entity(GSON.toJson(FACADE.useLocationName(name))).build();
    }


  */
}

