package blog.models;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idbook;

    @Column(nullable = false, length = 200)
    private String titleBook;

    @Column(nullable = false, length = 100)
    private String authorFullName;

    @Lob
    @Column()
    private String bookAbout;

    @Column(nullable = false, length = 50)
    private String username;

    //@ManyToOne(optional = false, fetch = FetchType.EAGER)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    // @JoinColumn(name="username",referencedColumnName = "username")
    //@Column(nullable = false, length = 100)
    private Category category;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    // @JoinColumn(name="username",referencedColumnName = "username")
    //@Column(nullable = false, length = 100)
    private User user;

    @Column(nullable = false)
    private Date datePost = new Date();
    /////////////////////////////////
    public String getAuthorFullName() {
        return authorFullName;
    }
    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }
    //id
    public Long getIdbook() {
        return idbook;
    }
    public void setIdbook(Long id_book) {
        this.idbook = idbook;
    }
   //title
    public String getTitleBook() {
        return titleBook;
    }
    public void setTitleBook(String titleBook) {
        this.titleBook = titleBook;
    }
    //bookAbout
    public String getBookAbout() {
        return bookAbout;
    }
    public void setBookAbout(String bookAbout) {
        this.bookAbout = bookAbout;
    }
  //username
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
   //category
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    ///////////////////////////////////////
    public Book(){
    }
    public Book(Long idbook, String title, String authorFullName,String bookAbout,Category category,
                    User user) {
        this.idbook = idbook;
        this.titleBook = title;
        this.bookAbout = bookAbout;
        this.category= category;
        this.user= user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + idbook +
                ", title='" + titleBook + '\'' +
                ", author=" + authorFullName +
                ", content='" + bookAbout + '\'' +
                ", category='" + category + '\'' +
                ", user=" +user +
                '}';
    }

}
