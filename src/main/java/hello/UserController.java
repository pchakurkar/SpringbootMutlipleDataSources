package hello;

import hello.userlocation.UserLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by prajaktac on 8/14/17.
 */
@Controller
@RequestMapping(path="/demo")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserLocationService userLocationService;
    @Autowired
    private CommonService commonService;

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public @ResponseBody String addUser(@RequestParam String name, @RequestParam String email) {
        userService.addUser(name, email);
        return "SUCCESS";
    }

    @RequestMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(path = "/userLocation/add", method = RequestMethod.GET)
    public @ResponseBody String addUserLocation(@RequestParam int userId, @RequestParam String city, @RequestParam String state, @RequestParam String country, @RequestParam String zipCode) {
        userLocationService.addUserLocation(userId, city, state, country, zipCode);
        return "SUCCESS";
    }

    @RequestMapping(path = "/locations")
    public @ResponseBody Iterable<UserLocation> getAllUserLocations() {
        return userLocationService.getAllLocations();
    }

    @RequestMapping(path = "/add/user/data", method = RequestMethod.POST)
    public @ResponseBody String addUserData(@RequestParam String name, @RequestParam String email,
                                            @RequestParam String city, @RequestParam String state,
                                            @RequestParam String country, @RequestParam String zipcode) {

        try {
            for(int i=1; i< 3; i++) {
                System.out.print("setting the cluster to " + i + "\n");
                CurrentRequestFilter.setUserCluster(i);

                System.out.print("The cluster key is " + CurrentRequestFilter.getUserCluster() + "\n");
                commonService.addUserData(name, email, city, state, country, zipcode);
            }
        } catch (Exception ex) {
            System.out.println("error occurred\n" + ex.getMessage());
            return "ERROR";
        }

        return "SUCCESS";

    }
}
