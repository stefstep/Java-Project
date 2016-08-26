package blog.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iduser;

    @Column(nullable = false, length = 50, unique = true)
    private String username;

    // @Column(length = 100)
    // private String pass_Hashkey;


    @Column(nullable = false,length = 200)
    private String password_hashed;

    @Column(length = 100)
    private String fullname;

    @Column(nullable = false,length = 100, unique = true)
    private String emailuser;

    @Column(length = 100)
    private String picturelink;

    @Column(nullable = false)
    private Date date = new Date();


    /////////////////////////////////
    //foreign key
    @OneToMany(mappedBy = "author")
    private Set<Post> posts = new HashSet<Post>();
    //foreign key
    @OneToMany(mappedBy = "user")
    private Set<Book> books = new HashSet<Book>();
    //foreign key
    @OneToMany(mappedBy = "user")
    private Set<Comment_book> cmntbooks = new HashSet<Comment_book>();
    //foreign key
    @OneToMany(mappedBy = "user")
    private Set<Comment_event> cmntevents = new HashSet<Comment_event>();
    //foreign key
    @OneToMany(mappedBy = "user")
    private Set<Comment_post> cmntposts = new HashSet<Comment_post>();
    //foreign key
    @OneToMany(mappedBy = "user")
    private Set<Event> events = new HashSet<Event>();
  ///////////////////////////////////////////
    public Long getIduser() {
        return iduser;
    }
    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword_hashed() {  return password_hashed;  }
    public void setPassword_hashed(String password_hashed) {     this.password_hashed = password_hashed;
    }
   ////FK
    public Set<Post> getPosts() { return posts;  }
    public void setPosts(Set<Post> posts) { this.posts = posts;  }
    //FK
    public Set<Book> getBooks() {
        return books;
    }
    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    //
    public String getEmailuser() {
        return emailuser;
    }
    public void setEmailuser(String emailuser) {
        this.emailuser = emailuser;
    }

    public String getPicturelink() {
        return picturelink;
    }
    public void setPicturelink(String picturelink) {
        this.picturelink = picturelink;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }


    public Set<Comment_book> getCmntbooks() { return cmntbooks; }
    public void setCmntbooks(Set<Comment_book> cmntbooks) { this.cmntbooks = cmntbooks;
    }

    public Set<Comment_event> getCmntevents() { return cmntevents;}
    public void setCmntevents(Set<Comment_event> cmntevents) {  this.cmntevents = cmntevents;
    }

    public Set<Comment_post> getCmntposts() { return cmntposts; }
    public void setCmntposts(Set<Comment_post> cmntposts) {  this.cmntposts = cmntposts;
    }
   //FK
    public Set<Event> getEvents() { return events; }
    public void setEvents(Set<Event> events) {  this.events = events;
    }
    ///////////////////////////////////////////////
    public User() {
    }

    public User(String username, String fullname) {
        this.username = username;
        this.fullname = fullname;
    }

    public User(Long iduser, String username, String fullname) {
        this.iduser = iduser;
        this.username = username;
        this.fullname = fullname;
    }
    @Override
    public String toString() {
        return "User{" +
                "iduser=" + iduser +
                ", username='" + username + '\'' +
                ", passwordHashed='" + password_hashed + '\'' +
                ", fullname='" + fullname + '\'' +
                '}';
    }

}
