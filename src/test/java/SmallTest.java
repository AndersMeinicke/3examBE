import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.MatchDTO;
import dtos.PlayerDTO;
import dtos.PlayerMatchesDTO;
import entities.Location;
import errorhandling.API_Exception;
import facades.MatchFacade;
import facades.PlayerFacade;
import javassist.NotFoundException;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import java.io.IOException;
import java.util.List;

public class SmallTest {
    public static void main(String[] args) throws IOException, API_Exception, NotFoundException {
        EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
        MatchFacade FACADE = MatchFacade.getmatchFacade(EMF);
        Gson GSON = new GsonBuilder().setPrettyPrinting().create();
        String location = "{city: 'test', address: 'test', conditions: 'god'}";
        Location location1 =GSON.fromJson(location, Location.class);
        System.out.println(location1.getAddress());
        System.out.println(location1.getConditions());
       // List<MatchDTO> matches = FACADE.getMatchesFromLocationName("helsingor");
      //  for (MatchDTO m: matches
     //        ) {
     //       System.out.println("no " + m.getJudge() + " " + m.getOpponentTeam());
     //   }
    }
}