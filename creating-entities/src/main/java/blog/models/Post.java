package blog.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpost;

    @Column(nullable = false, length = 300)
    private String titlePost;

    @Lob
    @Column(nullable = false)
    private String contentPost;

    //@ManyToOne(optional = false, fetch = FetchType.EAGER)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    // @JoinColumn(name="username",referencedColumnName = "username")
    //@Column(nullable = false, length = 100)
    private User author;

  //@ManyToOne(optional = false, fetch = FetchType.EAGER)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Category category;

    @Column(nullable = false)
    private Date datePost = new Date();
    ////////////////////////////////////////////////////
    //foreign key
    @OneToMany(mappedBy = "post")
    private Set<Comment_post> cmntposts = new HashSet<Comment_post>();
    ////FK
    public Set<Comment_post> getPosts() { return cmntposts;  }
    public void setPosts(Set<Comment_post> cmntosts) { this.cmntposts = cmntposts;  }
    /////////////////////////////////////
    public Long getId() {
        return idpost;
    }
    public void setId(Long idpost) {
        this.idpost = idpost;
    }

    public String getTitle() {
        return titlePost;
    }
    public void setTitle(String titlePost) {
        this.titlePost = titlePost;
    }

    public String getBody() {
        return contentPost;
    }
    public void setBody(String contentPost) {
        this.contentPost = contentPost;
    }
     //author
    public User getAuthor() {  return author; }
    public void setAuthor(User author) {this.author = author; }
    //category`
    public Category getCategory() { return category;  }
    public void setCategory(Category category) { this.category = category;
    }
     //date
    public Date getDatePost() {       return datePost;    }
    public void setDatePost(Date datePost) {  this.datePost = datePost;
    }

    ///////////////////////////////////////
    // public PostTwo(Long idpost, String title, String content, String author) {
    public Post(Long idpost, String title, String content, User author) {
        this.idpost = idpost;
        this.titlePost = title;
        this.contentPost = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + idpost +
                ", title='" + titlePost + '\'' +
                ", content='" + contentPost + '\'' +
                ", author=" + author +
                ", date=" + datePost +
                '}';
    }

}