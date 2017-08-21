package hello;

import hello.userlocation.UserLocation;
import hello.userlocation.UserLocationRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prajaktac on 8/15/17.
 */
@Component
public class UserLocationService {
    @Autowired
    private UserLocationRepositoryImpl userLocationRepository;


    public void addUserLocation(int userId, String city, String state, String country, String zipCode) {
        userLocationRepository.insert(userId, city, state, country, zipCode);
    }

    public Iterable<UserLocation> getAllLocations() {
        List locations = new ArrayList<>();
        return locations;
    }


}
