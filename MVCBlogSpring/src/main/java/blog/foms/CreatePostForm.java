package blog.foms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Hristo on 05.08.2016 г..
 */
public class CreatePostForm {
    @NotNull
    @Size(min=2, max=30)
    private String title;

    @NotNull
    @Size(min=1, max=200000)
    private String body;
/*
    private Date date;*/

    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

  /*  public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
*/
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
