package DAO;

/**
 * Created by DELL on 2018/7/18.
 */
public class Account {
    private int id;
    private String userAccount;
    private String userPassword;

    public String getUserPassword() {
       return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
