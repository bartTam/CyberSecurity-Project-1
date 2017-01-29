package sec.project.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Account extends AbstractPersistable<Long> {

    private String username;
    private String password;
    private boolean isAdmin;
    private int posts;

    public Account() {
        super();
    }

    public Account(String username, String password, boolean isAdmin) {
        this();
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.posts = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin(){
        return isAdmin;
    }
    
    public void setIsAdmin(boolean isAdmin){
        this.isAdmin = isAdmin;
    }
    
    public int getPostNumber(){
        System.out.println(posts + " posts");
        return posts;
    }
    
    public void setPostNumber(int posts){
        this.posts = posts;
        System.out.println(posts + " posts");
    }
}
