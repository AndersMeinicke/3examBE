import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.*;
import facades.*;
import utils.EMF_Creator;

import javax.management.relation.RoleList;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello");

        EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
        UserFacade FACADE =  UserFacade.getUserFacade(EMF);
        LocationFacade LFACADE = LocationFacade.getLocationFacade(EMF);
        PlayerFacade PFACADE = PlayerFacade.getplayerFacade(EMF);
        MatchFacade MFACADE = MatchFacade.getmatchFacade(EMF);

        Role role = new Role("admin");
        List RoleList = new ArrayList<>();
        RoleList.add(role);

        User user = new User("Oliver","test123",RoleList);

        Location location = new Location("Dontknow", "BORG", "bad");

        Player player = new Player("hani","123@123",12345678,"active");
        Match match = new Match("Pokemon","Anders Meinicke","Videospil",true,2);
        //FACADE.createUser(user);
        //GFACADE.createGuide(guide);
       // LFACADE.createLocation(location);
        //PFACADE.createplayer(player);
       // MFACADE.creatematch(match);

    }
}
