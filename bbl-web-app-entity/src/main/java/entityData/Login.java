package entityData;

public class Login {
    private int iD;
    private String username;
    private String password;

    public Login() {
        this.iD = 0;
        this.username = "";
        this.password = "";
    }

    public Login(int iD, String username, String password) {
        this.iD = iD;
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return "login{" +
                "iD=" + iD +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
