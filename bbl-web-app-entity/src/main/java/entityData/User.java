package entityData;

import java.util.Date;

public class User {
    private int iD;
    private String username;
    private String password;
    private Date timestampRegister;
    private Date timestampUpdate;

    public User() {
        this.iD = 0;
        this.username = "";
        this.password = "";
        this.timestampRegister = new Date();
        this.timestampUpdate = new Date();
    }

    public User(int iD, String username, String password, Date timestampRegister, Date timestampUpdate) {
        this.iD = iD;
        this.username = username;
        this.password = password;
        this.timestampRegister = timestampRegister;
        this.timestampUpdate = timestampUpdate;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getTimestampRegister() {
        return timestampRegister;
    }

    public void setTimestampRegister(Date timestampRegister) {
        this.timestampRegister = timestampRegister;
    }

    public Date getTimestampUpdate() {
        return timestampUpdate;
    }

    public void setTimestampUpdate(Date timestampUpdate) {
        this.timestampUpdate = timestampUpdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "iD=" + iD +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", timestampRegister=" + timestampRegister +
                ", timestampUpdate=" + timestampUpdate +
                '}';
    }
}
