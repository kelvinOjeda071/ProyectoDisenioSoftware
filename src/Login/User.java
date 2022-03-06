
package Login;

/**
 *
 * @author KelvinOjeda
 */
public class User {
    private String firstName;
    private String lastName;
    private long id;
    private String password;
    private int score;

    public User(String firstName, String lastName, long id, String password ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.password = password;
        
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
    
    
}
