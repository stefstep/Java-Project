package blog.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcategory;

    @Column(nullable = false, length = 50, unique = true)
    private String category;

    @Column(nullable = false, length = 100)
    private String typeCategory;

    @Lob
    @Column()
    private String catAbout;
/////////////////////////////////
//foreign key
    @OneToMany(mappedBy = "category")
    private Set<Post> posts = new HashSet<Post>();
    //foreign key
    @OneToMany(mappedBy = "category")
    private Set<Book> books = new HashSet<Book>();
   //foreign key
    @OneToMany(mappedBy = "category")
    private Set<Event> events = new HashSet<Event>();
    ///////////////////////////////////////////////
    public String getCatAbout() {
        return catAbout;
    }
    public void setCatAbout(String catAbout) {
        this.catAbout = catAbout;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public Long getIdcategory() {
        return idcategory;
    }
    public void setIdcategory(Long idcategory) {
        this.idcategory = idcategory;
    }
 //typeCategory
    public String getTypeCategory() { return typeCategory;  }
    public void setTypeCategory(String typeCategory) {
        this.typeCategory = typeCategory;
    }

    public Set<Post> getPosts() { return posts; }
    public void setPosts(Set<Post> posts) { this.posts = posts; }

    public Set<Book> getBooks() { return books; }
    public void setBooks(Set<Book> books) { this.books = books; }

    public Set<Event> getEvents() {  return events; }
    public void setEvents(Set<Event> events) {this.events = events; }
    ///////////////////////////////////////////////
    public Category() {
    }

    public Category(String category, String catAbout) {
        this.category = category;
        this.catAbout = catAbout;
    }

    public Category(Long idcategory, String category, String catAbout) {
        this.idcategory = idcategory;
        this.category = category;
        this.catAbout = catAbout;
    }

    @Override
    public String toString() {
        return "Category{" +
                "idcategory=" + idcategory +
                ", category='" +category + '\'' +
                ", catAbout='" + catAbout + '\'' +
                '}';
    }


}
