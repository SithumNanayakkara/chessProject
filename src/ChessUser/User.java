package ChessUser;

/**
 *
 * @author Sithum Nanayakkara <fhb7119@autuni.ac.nz>
 */
public class User 
{
    private String userName;
    private String Password;

    public User(String user, String pass) {
        this.userName = user;
        this.Password = pass;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String user) {
        this.userName = user;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String pass) {
        this.Password = pass;
    }
}
