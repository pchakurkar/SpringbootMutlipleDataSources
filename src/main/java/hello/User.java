package hello;

/**
 * Created by prajaktac on 8/14/17.
 */
// @Entity
public class User {
    // @Id
    // @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private String email;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

