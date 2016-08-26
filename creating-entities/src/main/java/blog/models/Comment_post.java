package blog.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments_posts")
public class Comment_post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCmntPost;

    //@ManyToOne(optional = false, fetch = FetchType.EAGER)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    // @JoinColumn(name="username",referencedColumnName = "username")
    //@Column(nullable = false, length = 100)
    private Post post;

    @Column( length = 100)
    private String TitleComment;

    @Column( length = 500)
    private String textComment;

    //@ManyToOne(optional = false, fetch = FetchType.EAGER)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    // @JoinColumn(name="username",referencedColumnName = "username")
    //@Column(nullable = false, length = 100)
    private User user;

    @Column(nullable = false)
    private Date dateComment = new Date();
    ///////////////////////////////////////////
    //idCmntBook
    public Long getIdCmntPost() { return idCmntPost; }
    public void setIdCmntPost(Long idCmntPost) {
        this.idCmntPost = idCmntPost;
    }
    //idbook
    public Post getPost() { return post;  }
    public void setIdpost(Post post) {this.post = post;
    }
    //titlecom
    public String getTitleComment() { return TitleComment;  }
    public void setTitleComment(String titleComment) { TitleComment = titleComment;
    }
    //text
    public String getTextComment() {  return textComment;  }
    public void setTextComment(String textComment) {    this.textComment = textComment;
    }
    //iduser
    public User getUser() { return user; }
    public void setUser(User user) {  this.user = user;
    }
    //date
    public Date getDateComment() {  return dateComment; }
    public void setDateComment(Date dateComment) {    this.dateComment = dateComment;
    }
    ///////////////////////////////////////////////
    public Comment_post() {
    }

    public Comment_post(Post post,String TitleComment, String textComment) {
        this.post= post;
        this.TitleComment= TitleComment;
        this.textComment = textComment;
    }

    public Comment_post(Long idCmntPost, Post post,String TitleComment, String textComment) {
        this.idCmntPost = idCmntPost;
        this.post= post;
        this.TitleComment = TitleComment;
        this.textComment = textComment;
    }

    @Override
    public String toString() {
        return "Category{" +
                "idCmntPost=" +idCmntPost +
                "postid=" +post +
                ", TitleComment='" +TitleComment + '\'' +
                ", textComment='" + textComment + '\'' +
                '}';
    }


}
