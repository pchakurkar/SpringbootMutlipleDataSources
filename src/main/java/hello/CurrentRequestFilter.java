package hello;

/**
 * Created by prajaktac on 8/17/17.
 */
public class CurrentRequestFilter {
    private static ThreadLocal<Integer> userCluster = new ThreadLocal<>();

    public static void setUserCluster(int userClusterId) {
        userCluster.set(userClusterId);
    }

    public static Integer getUserCluster() {
        return userCluster.get();
    }
}
