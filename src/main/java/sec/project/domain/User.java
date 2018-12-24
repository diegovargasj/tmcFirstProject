package sec.project.domain;

import java.util.ArrayList;
import javafx.util.Pair;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class User extends AbstractPersistable<Long> {

    public String username;
    public String email;
    public String password;
    public String secretMessage;
    public int privilege; // 0 -> user; 1 -> admin
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public User() {
        super();
        this.privilege = 0;
        this.secretMessage = "Create your secret message!";
    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getPrivilege() {
        return this.privilege;
    }
    
    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }
    
    public String getSecretMessage() {
        return this.secretMessage;
    }
    
    public void setSecretMessage(String secretMessage) {
        this.secretMessage = secretMessage;
    }
    
    public ArrayList<Pair> getAttributes() {
        ArrayList<Pair> attributes = new ArrayList<>();
        attributes.add(new Pair<String, String>("username", this.username));
        attributes.add(new Pair<String, String>("secretMessage", this.secretMessage));
        attributes.add(new Pair<String, String>("email", this.email));
        return attributes;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return this.username + ", " + this.email + ", " + this.password + ", " + 
                this.privilege + ", " + this.secretMessage;
    }

}
