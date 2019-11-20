package graeme.hosford.rob.morgan.assignment2.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {

    public static final String USER = "ROLE_USER";

    @Id
    private String email;

    @Column
    private String description;

    public Role() {
    }

    public Role(String email, String description) {
        this.email = email;
        this.description = description;
    }

    public String getUserEmail() {
        return email;
    }

    public void setUserEmail(String userEmail) {
        this.email = userEmail;
    }

    public String getRoleDescription() {
        return description;
    }

    public void setRoleDescription(String roleDescription) {
        this.description = roleDescription;
    }
}
