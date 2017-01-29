package sec.project.domain;

import java.util.Vector;
import javax.persistence.Entity;


/**
 *
 * @author MrBart
 */

public class Thread {
    private Vector<Post> posts;
    private String title;
    
    
    public Thread(String title){
        posts = new Vector<Post>();
        this.title = title;
    }
    
    public Thread(String title, Post firstPost){
        this(title);
        posts.add(firstPost);
    }
    
    public Vector<Post> getPosts(){
        return posts;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void changeTitle(String newTitle){
        title = newTitle;
    }
    
    public void post(Post post){
        posts.add(post);
    }
}
