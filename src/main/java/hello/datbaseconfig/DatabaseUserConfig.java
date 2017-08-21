package hello.datbaseconfig;


import hello.MultitenantDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by prajaktac on 8/16/17.
 */
@Configuration
public class DatabaseUserConfig {

    @Autowired
    private Environment env;

    @Bean (name="dsUsers")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource userDataSource() {
        Map<Object, Object> resolvedDataSources = new HashMap<>();
        for (int i = 1; i < 3; i++) {

            String strDBPropPrefix = "spring.datasource.user" + i + ".";
            DataSourceBuilder dataSourceBuilder = new DataSourceBuilder(this.getClass().getClassLoader());
            dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver")
                    .url(env.getProperty(strDBPropPrefix + "url"))
                    .username(env.getProperty(strDBPropPrefix + "username"))
                    .password(env.getProperty(strDBPropPrefix + "password"));

            resolvedDataSources.put(i, dataSourceBuilder.build());
        }

        MultitenantDataSource dataSource = new MultitenantDataSource();
        dataSource.setDefaultTargetDataSource(resolvedDataSources.get(1));
        dataSource.setTargetDataSources(resolvedDataSources);


        // Call this to finalize the initialization of the data source.
        dataSource.afterPropertiesSet();

        return dataSource;
    }

    @Bean(name = "jdbcUsers")
    @Autowired
    public JdbcTemplate jdbcTemplate(@Qualifier("dsUsers") DataSource dsUsers) {
        return new JdbcTemplate(dsUsers);
    }

}
