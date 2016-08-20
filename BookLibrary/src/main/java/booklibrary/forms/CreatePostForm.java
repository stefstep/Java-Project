package booklibrary.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Hristo on 05.08.2016 г..
 */
public class CreatePostForm {

    private String title;

    private String body;
/*
    private Date date;*/

    private String author_id;

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

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }
}
