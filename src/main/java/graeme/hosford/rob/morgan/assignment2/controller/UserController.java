package graeme.hosford.rob.morgan.assignment2.controller;

import graeme.hosford.rob.morgan.assignment2.controller.form.RegisterForm;
import graeme.hosford.rob.morgan.assignment2.data.entities.Role;
import graeme.hosford.rob.morgan.assignment2.data.entities.User;
import graeme.hosford.rob.morgan.assignment2.service.RoleService;
import graeme.hosford.rob.morgan.assignment2.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private RoleService roleService;
    private UserService userService;
    private PasswordEncoder passwordEncoder;

    public UserController(RoleService roleService, UserService userService, PasswordEncoder passwordEncoder) {
        this.roleService = roleService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }

    @PostMapping(value = "/registerUser")
    public String addNewUser(@Valid @ModelAttribute("registerForm") RegisterForm registerForm,
                             BindingResult binding) {
        if (binding.hasErrors()) {
            return "/register";
        }

        Role role = new Role(registerForm.getEmail(), Role.USER);
        roleService.save(role);

        User user = new User(registerForm.getName(), registerForm.getPhone(),
                registerForm.getEmail(), passwordEncoder.encode(registerForm.getPassword()), role);
        userService.save(user);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
