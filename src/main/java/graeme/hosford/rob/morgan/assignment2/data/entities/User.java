package graeme.hosford.rob.morgan.assignment2.data.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name = "UserName", nullable = false)
    private String userName;

    @Column(name = "UserPhone", nullable = false)
    private String userPhone;

    @Column(name = "UserEmail", nullable = false)
    private String userEmail;

    @Column(name = "UserPassword", nullable = false)
    private String userPassword;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Bid> userBids = new ArrayList<>();

    public User() {
    }

    public User(String userName, String userPhone, String userEmail, String userPassword) {
        this.userName = userName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public List<Bid> getUserBids() {
        return userBids;
    }

    public void setUserBids(List<Bid> userBids) {
        this.userBids = userBids;
    }

}
