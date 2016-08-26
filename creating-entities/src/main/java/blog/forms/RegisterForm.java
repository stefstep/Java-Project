package blog.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterForm {
    @Size(min=2, max=30, message = "Username size should be in the range [2...30]")
    private String username;

    @NotNull
    @Size(min=9, max=50)
    private String email;

    @NotNull
    @Size(min=1, max=50)
    private String password;

    private String fullname;

    private String picturelink;
    ///////////////////////////////////////
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
   //
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
   //
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
   //
    public String getEmail() {  return email; }
    public void setEmail(String email) {  this.email = email; }
   //
    public String getPicturelink() {return picturelink; }
    public void setPicturelink(String picturelink) { this.picturelink = picturelink; }
}
