
package sec.project.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author MrBart
 */
@Entity
public class Post implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String author;
    private String message;

    protected Post() {}
    
    public Post(String author, String message){
        this.author = author;
        this.message = message;
    }
    
    public void editMessage(String newMessage){
        message = newMessage;
    }
    
    public String getMessage(){
        return message;
    }
    
    public String getAuthor(){
        return author;
    }
    
    @Override
    public String toString(){
        return String.format("Customer[id=%d, author='%s', message='%s'", id, author, message);
    }
}
