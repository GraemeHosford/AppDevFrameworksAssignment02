package graeme.hosford.rob.morgan.assignment2.controller.form;

import javax.validation.constraints.Size;

public class RegisterForm {

    @Size(min = 5)
    private String email;

    @Size(min = 8, max = 20)
    private String password;

    @Size(min = 3, max = 25)
    private String name;

    @Size(max = 10, min = 10)
    private String phone;

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
