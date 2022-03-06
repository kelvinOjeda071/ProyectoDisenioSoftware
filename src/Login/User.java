
package Login;

import Asteroid.IO.JSONParser;
import Asteroid.IO.ScoreData;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KelvinOjeda
 */
public class User {
    private String firstName;
    private String lastName;
    private String id;
    private String password;
    private String gameType;
    private int score;
    private String date;

    public User(String firstName, String lastName, String id, String gameType,String password, ScoreData scoreData ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.gameType = gameType;
        this.password = password;
        this.score = scoreData.getScore();
        this.date = scoreData.getDate();
    }
    public User(String firstName, String lastName, String id, String gameType,String password, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.gameType = gameType;
        this.password = password;
        this.score = score;
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.date = format.format(today);
    }

    public User() {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }
    
    public void logIn(){
        
    }
    
    public void signIn(){
      
    }
    
    
    
    
    
    
    
    
    
}
