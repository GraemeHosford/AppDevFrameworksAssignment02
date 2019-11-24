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
    private String name;

    @Column
    private String phone;

    @Column
    @Email
    private String email;

    @Column
    private String password;

    @Column
    private boolean enabled;

    @OneToOne
    @JoinColumn(name = "roleemail", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "userRef", fetch = FetchType.EAGER)
    private List<Job> userJobs = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Bid> userBids = new ArrayList<>();

    public User() {
    }

    public User(String name, String phone, String email, String password, Role role) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.enabled = true;
        this.role = role;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
