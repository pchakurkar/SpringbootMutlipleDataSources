package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by prajaktac on 8/17/17.
 */
@Component
public class CommonService {
    @Autowired
    private UserService userService;
    @Autowired
    private UserLocationService userLocationService;

    // if I make this method @Transactional, and try to switch the datasources, it does not switch the data source.
    @Transactional
    public String addUserData(String name,String email,
                       String city, String state,
                       String country, String zipcode) {
        // CurrentRequestFilter.setUserCluster(1);
        System.out.println("The current request shard after 1 is " + CurrentRequestFilter.getUserCluster());
        userService.addUser(name, email);
        // CurrentRequestFilter.setUserCluster(2);
        System.out.println("The current request shars is " + CurrentRequestFilter.getUserCluster());
        userService.addUserLocation(3, city, state, country, zipcode);
        return "SUCCESS";
    }
}
