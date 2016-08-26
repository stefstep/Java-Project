package blog.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvent;

    @Column(nullable = false, length = 100)
    private String nameEvent;

    @Column(nullable = false, length = 700)
    private String aboutEvent;

    @Column(nullable = false, length = 100)
    private String placeEvent;

    @Column(nullable = false, length = 100)
    private String dateEvent;

    //@ManyToOne(optional = false, fetch = FetchType.EAGER)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    // @JoinColumn(name="username",referencedColumnName = "username")
    //@Column(nullable = false, length = 100)
    private Category category;

    //@ManyToOne(optional = false, fetch = FetchType.EAGER)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    // @JoinColumn(name="username",referencedColumnName = "username")
    //@Column(nullable = false, length = 100)
    private User user;

    @Column(nullable = false)
    private Date date= new Date();
///////////////////////////////
    //id
    public Long getIdEvents() { return idEvent; }
    public void setIdEvents(Long idEvents) {    this.idEvent = idEvents;
    }
   //nameevent
    public String getNameEvent() { return nameEvent; }
    public void setNameEvent(String nameEvent) {   this.nameEvent = nameEvent;
    }
    //aboutevent
    public String getAboutEvent() {return aboutEvent;  }
    public void setAboutEvent(String aboutEvent) { this.aboutEvent = aboutEvent;
    }
     //place
    public String getPlaceEvent() { return placeEvent;  }
    public void setPlaceEvent(String placeEvent) {   this.placeEvent = placeEvent;
    }
     ///category
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category =category;
    }
    //user
    public User getUser() { return user; }
    public void setUser(User user) {  this.user = user;
    }
    //dateEvent
    public String getDateEvent() { return dateEvent;  }
    public void setDateEvent(String dateEvent) {    this.dateEvent = dateEvent;
    }
   //date posted
    public Date getDate() { return date;  }
    public void setDate(Date date) {   this.date = date;
    }
    //////////////////////////////////////////
    //foreign key
    @OneToMany(mappedBy = "event")
    private Set<Comment_event> cmntevents = new HashSet<Comment_event>();
    ////FK
    public Set<Comment_event> getPosts() { return cmntevents;  }
    public void setPosts(Set<Comment_post> posts) { this.cmntevents = cmntevents;  }
    ///////////////////////////////////////////////
    public Event() {
    }

    public Event(String TitleEvent, String textEvent) {
        this.nameEvent= TitleEvent;
        this.aboutEvent = textEvent;
    }

    public Event(Long idEvent, String TitleEvent, String textEvent,User user) {
        this.idEvent = idEvent;
        this.nameEvent = TitleEvent;
        this.aboutEvent = textEvent;
        this.user =user;
    }

    @Override
    public String toString() {
        return "Category{" +
                "idEvent=" +idEvent +
                ", nameEvent='" +nameEvent + '\'' +
                ",aboutEvent ='" + aboutEvent + '\'' +
                '}';
    }

}
