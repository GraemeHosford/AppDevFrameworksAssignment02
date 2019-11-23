package graeme.hosford.rob.morgan.assignment2.controller.form;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegisterForm {

    @Column(name = "Email")
    @Email
    @NotBlank
    private String email;

    @Column(name = "Password")
    @Size(min = 3, max = 20)
    private String password;

    @Column(name = "Name")
    @Size(min = 3, max = 25)
    private String name;

    @Column(name = "Phone")
    @Size(max = 10, min = 10)
    private String phone;

    public RegisterForm() {
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
}
