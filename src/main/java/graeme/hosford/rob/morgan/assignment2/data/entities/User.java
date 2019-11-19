package graeme.hosford.rob.morgan.assignment2.data.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column
    private String userName;

    @Column
    private String userPhone;

    @Column
    @Email
    private String useremail;

    @Column
    private String userpassword;

    @Column
    private boolean userenabled;

    @OneToOne
    @JoinColumn(name = "roleemail", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "userRef", fetch = FetchType.EAGER)
    private List<Job> userJobs = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Bid> userBids = new ArrayList<>();

    public User() {
    }

    public User(String userName, String userPhone, String userEmail, String userPassword, Role userRole) {
        this.userName = userName;
        this.userPhone = userPhone;
        this.useremail = userEmail;
        this.userpassword = userPassword;
        this.userenabled = true;
        this.role = userRole;
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

    public List<Job> getUserJobs() {
        return userJobs;
    }

    public void setUserJobs(List<Job> userJobs) {
        this.userJobs = userJobs;
    }

    public List<Bid> getUserBids() {
        return userBids;
    }

    public void setUserBids(List<Bid> userBids) {
        this.userBids = userBids;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public boolean isUserenabled() {
        return userenabled;
    }

    public void setUserenabled(boolean userenabled) {
        this.userenabled = userenabled;
    }
}
