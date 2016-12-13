package dtos;

import java.io.Serializable;

public class UserDTO implements Serializable{

    protected String username;
    protected String name;
    protected String email;

    public UserDTO() {
    }    
    
    public UserDTO(String username, String name, String email) {
        this.username = username;
        this.name = name;
        this.email = email;
    }
    
    public void reset() {
        setUsername(null);
        setName(null);
        setEmail(null);
    }        

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
