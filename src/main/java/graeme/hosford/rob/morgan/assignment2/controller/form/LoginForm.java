package graeme.hosford.rob.morgan.assignment2.controller.form;

import javax.validation.constraints.Size;

public class LoginForm {

    @Size(min = 5)
    private String email;

    @Size(min = 8, max = 20)
    private String password;

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
}