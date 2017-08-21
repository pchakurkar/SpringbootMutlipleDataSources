package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by prajaktac on 8/15/17.
 */
@Component
public class UserService {
    @Autowired
    UserRepositoryImpl userRepository;

    public void addUser(String name, String email) {
        userRepository.insertUser(name, email);
    }

    public void addUserLocation(int userId, String city, String state, String country, String zipCode) {
        userRepository.insert(userId, city, state, country, zipCode);
    }

    public Iterable<User> getAllUsers() {
        return new ArrayList<>();
    }

}
