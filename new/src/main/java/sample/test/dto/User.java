package sample.test.dto;

/**
 * Created by charwer on 2014/11/4 004.
 */
public class User {

    public User() {
    }

    ;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
