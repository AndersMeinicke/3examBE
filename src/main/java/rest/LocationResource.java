package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.LocationDTO;
import dtos.MatchDTO;
import entities.Location;
import entities.Match;
import entities.Player;
import errorhandling.API_Exception;
import facades.LocationFacade;
import facades.MatchFacade;
import javassist.NotFoundException;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("location")
public class LocationResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final LocationFacade FACADE = LocationFacade.getLocationFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() throws NotFoundException {
        return Response.ok().entity(GSON.toJson(FACADE.getAllLocations())).build();
    }
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getSpecific(@PathParam("id") int id) throws API_Exception{
        return Response.ok().entity(GSON.toJson(FACADE.getLocationFromID(id))).build();
    }
    @PUT
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response editLocation(@PathParam("id") int id, String location)throws EntityNotFoundException {
        Location location1 =  GSON.fromJson(location, Location.class);
        LocationDTO locationDTO = FACADE.updateLocation(id,location1);
        return Response.ok().entity(GSON.toJson(locationDTO)).build();
    }
    @POST
    @Path("/create")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createLocation(String location){
        Location location1 =GSON.fromJson(location, Location.class);
        Location burner = new Location(location1.getAddress(), location1.getCity(), location1.getConditions());
        Location newLocation = FACADE.createLocation(burner);
        return Response.ok().entity(GSON.toJson(newLocation)).build();
    }
}

