package blog.models;

import javax.persistence.*;
import java.util.Date;

//@Entity
//@Table(name = "postsTwo")
public class PostTwo {
  /*  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpost;

    @Column(nullable = false, length = 300)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
     // @JoinColumn(name="username",referencedColumnName = "username")
    //@Column(nullable = false, length = 100)
    private User author;

    @Column(nullable = false, length = 100)
    private String category;

    @Column(nullable = false)
    private Date datePost = new Date();
    ////////////////////////////////////////////////////
    public Long getId() {
        return idpost;
    }

    public void setId(Long idpost) {
        this.idpost = idpost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return content;
    }

    public void setBody(String body) {
        this.content = body;
    }

     public User getAuthor() {  return author; }
   // public String getAuthor() {  return author; }
    public void setAuthor(User author) {this.author = author; }
   // public void setAuthor(String author) {this.author = author; }

    public String getCategory() { return category;  }

    public void setCategory(String category) { this.category = category;
    }
    public Date getDatePost() {       return datePost;    }

    public void setDatePost(Date datePost) {  this.datePost = datePost;
    }
    ///////////////////////////////////////
   // public PostTwo(Long idpost, String title, String content, String author) {
        public PostTwo(Long idpost, String title, String content, User author) {
        this.idpost = idpost;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + idpost +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author=" + author +
                ", datePost=" + datePost +
                '}';
    }
*/
}
