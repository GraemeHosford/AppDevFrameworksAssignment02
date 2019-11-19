package graeme.hosford.rob.morgan.assignment2.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {

    @Id
    private String roleEmail;

    @Column
    private String roleDescription;

    public Role() {
    }

    public Role(String userEmail, String roleDescription) {
        this.roleEmail = userEmail;
        this.roleDescription = roleDescription;
    }

    public String getUserEmail() {
        return roleEmail;
    }

    public void setUserEmail(String userEmail) {
        this.roleEmail = userEmail;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
