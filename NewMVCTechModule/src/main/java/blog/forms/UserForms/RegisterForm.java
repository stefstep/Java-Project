package blog.forms.UserForms;

import javax.servlet.annotation.MultipartConfig;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Hristo on 05.08.2016 г..
 */
    @MultipartConfig
public class RegisterForm {

    @Size(min=2, max=30, message = "Username size should be in the range [2...30]")
     private String username;

    @NotNull
    @Size(min=1, max=50)
    private String password_hash;

    private String fullname;
    //@Email(message = "this is email format")
    private String email;

    private String picturelink;
   ///////////
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String  password_hash) {
        this.password_hash = password_hash;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {return email;  }

    public void setEmail(String email) {this.email = email;  }

    public String getPicturelink() { return picturelink;  }
    public void setPicturelink(String picturelink) { this.picturelink = picturelink;
    }

}
