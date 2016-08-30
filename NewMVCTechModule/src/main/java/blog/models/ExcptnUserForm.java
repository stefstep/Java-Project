package blog.models;

/**
 * Created by owner's pc on 8/29/2016.
 */
public class ExcptnUserForm {
    private String userchekmsg;
    private String meilcheckmsg;
    private String namecheckmsg;

    public String getUserchekmsg() {return userchekmsg;  }

    public void setUserchekmsg(String userchekmsg) {    this.userchekmsg = userchekmsg;
    }
    public String getMeilcheckmsg() {return meilcheckmsg;  }
    public void setMeilcheckmsg(String meilcheckmsg) {this.meilcheckmsg = meilcheckmsg;
    }

    public String getNamecheckmsg() {return namecheckmsg;  }
    public void setNamecheckmsg(String namecheckmsg) {   this.namecheckmsg = namecheckmsg;
    }
}
