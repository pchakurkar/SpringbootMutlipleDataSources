package hello.userlocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by prajaktac on 8/16/17.
 */
@Repository
public class UserLocationRepositoryImpl {
    @Autowired
    @Qualifier("jdbcLocation")
    protected JdbcTemplate jdbc;

    public void insert(int userId, String city, String state, String country, String zipCode) {
        jdbc.update(
                "insert into user_location (user_id, city, state, country, zipcode) VALUES (?, ?, ?, ?, ?)",
                userId, city, state, country, zipCode);
    }

}
