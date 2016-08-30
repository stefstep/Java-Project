package blog.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
//@NamedQuery(name = "User.findByEmailAddress",
     //   query = "select u from User u where u.username = ?1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String username;



    @Column(length = 60)
    private String password_hash;

    @Column(length = 100)
    private String fullname;


    @Column(length = 100)
    private String email;



    @Column(length = 100)
    private String picturelink;

   // @OneToMany(mappedBy = "author")
   // private Set<Post> posts = new HashSet<Post>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword_hash() { return password_hash;  }

    public void setPassword_hash(String password_hash) {    this.password_hash = password_hash;
    }
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
   //email
    public String getEmail() {  return email;  }

    public void setEmail(String email) { this.email = email;  }

    public String getPicturelink() { return picturelink;    }
    public void setPicturelink(String picturelink) {  this.picturelink = picturelink;
    }
/*
    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
*/
    public User() {
    }

    public User(String username, String fullname) {
        this.username = username;
        this.fullname = fullname;
    }

    public User(Long id, String username, String fullname) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passwordHash='" + password_hash + '\'' +
                ", fullname='" + fullname + '\'' +
                '}';
    }
}