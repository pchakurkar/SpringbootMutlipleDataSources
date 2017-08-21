package hello.datbaseconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


/**
 * Created by prajaktac on 8/16/17.
 */
@Configuration
public class UserLocationDatabaseConfig {
    @Bean (name="dsLocation")
    @ConfigurationProperties(prefix="spring.secondDatasource")
    public DataSource locationDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jdbcLocation")
    @Autowired
    public JdbcTemplate jdbcTemplate(@Qualifier("dsLocation") DataSource dsLocation) {
        return new JdbcTemplate(dsLocation);
    }

}
