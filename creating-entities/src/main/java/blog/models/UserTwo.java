package blog.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//@Entity
public class UserTwo {
  /*  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusertwo;

    @Column(nullable = false, length = 50, unique = true)
    private String username;


    // @Column(length = 100)
    // private String pass_Hashkey;

    @Column(length = 100)
    private String password_hashed;

    @Column(length = 100)
    private String fullname;

    @Column(length = 100)
    private String emailuser;


    @Column(length = 100)
    private String picturelink;

    @Column(nullable = false)
    private Date date = new Date();
/////////////////////////////////
      @OneToMany(mappedBy = "author")
      private Set<PostTwo> posts = new HashSet<PostTwo>();

    public Long getIduser() {
        return idusertwo;
    }

    public void setIduser(Long idusertwo) {
        this.idusertwo = idusertwo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return password_hashed;
    }

    public void setPasswordHash(String passwordHash) {
        this.password_hashed = passwordHash;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

     public Set<PostTwo> getPosts() { return posts;  }

    public void setPosts(Set<PostTwo> posts) { this.posts = posts;  }

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
    // public String getPass_Hashkey() { return pass_Hashkey;  }

    //  public void setPass_Hashkey(String pass_Hashkey){this.pass_Hashkey = pass_Hashkey; }

    ///////////////////////////////////////////////
    public UserTwo() {
    }

    public UserTwo(String username, String fullname) {
        this.username = username;
        this.fullname = fullname;
    }

    public UserTwo(Long id, String username, String fullname) {
        this.idusertwo = idusertwo;
        this.username = username;
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "User{" +
                "idusertwo=" + idusertwo +
                ", username='" + username + '\'' +
                ", passwordHashed='" + password_hashed + '\'' +
                ", fullname='" + fullname + '\'' +
                '}';
    }
*/
}
