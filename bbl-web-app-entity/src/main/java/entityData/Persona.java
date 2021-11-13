package entityData;

import java.util.Date;

public class Persona {
    private int iD;
    private String firstname;
    private String lastname;
    private String birthday;
    private String email;
    private Date timestampRegister;
    private Date getTimestampUpdate;
    private User objUser;

    public Persona() {
        this.iD = 0;
        this.firstname = "";
        this.lastname = "";
        this.birthday = "";
        this.email = "";
        this.timestampRegister = new Date();
        this.getTimestampUpdate = new Date();
        this.objUser = new User();
    }

    public Persona(int iD, String firstname, String lastname, String birthday, String email, Date timestampRegister, Date getTimestampUpdate, User objUser) {
        this.iD = iD;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.email = email;
        this.timestampRegister = timestampRegister;
        this.getTimestampUpdate = getTimestampUpdate;
        this.objUser = objUser;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getTimestampRegister() {
        return timestampRegister;
    }

    public void setTimestampRegister(Date timestampRegister) {
        this.timestampRegister = timestampRegister;
    }

    public Date getGetTimestampUpdate() {
        return getTimestampUpdate;
    }

    public void setGetTimestampUpdate(Date getTimestampUpdate) {
        this.getTimestampUpdate = getTimestampUpdate;
    }

    public User getObjUser() {
        return objUser;
    }

    public void setObjUser(User objUser) {
        this.objUser = objUser;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "iD=" + iD +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                ", timestampRegister=" + timestampRegister +
                ", getTimestampUpdate=" + getTimestampUpdate +
                ", objUser=" + objUser +
                '}';
    }
}
