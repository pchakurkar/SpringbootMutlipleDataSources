package hello;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by prajaktac on 8/17/17.
 */
public class MultitenantDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("The datasource key from multitenant is " + CurrentRequestFilter.getUserCluster() + "\n");
        return CurrentRequestFilter.getUserCluster();
    }
}
