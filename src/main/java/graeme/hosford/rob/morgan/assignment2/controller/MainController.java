package graeme.hosford.rob.morgan.assignment2.controller;

import graeme.hosford.rob.morgan.assignment2.UserForm;
import graeme.hosford.rob.morgan.assignment2.data.entities.Job;
import graeme.hosford.rob.morgan.assignment2.data.entities.User;
import graeme.hosford.rob.morgan.assignment2.service.JobService;
import graeme.hosford.rob.morgan.assignment2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    private JobService jobService;
    private UserService userService;

    @Autowired
    public MainController(JobService jobService, UserService userService) {
        this.jobService = jobService;
        this.userService = userService;
    }

    @GetMapping(value = {"/", "/index"})
    public String indexMapping(Model model) {
        List<Job> jobs = jobService.getAllJobs();
        model.addAttribute(jobs);
        return "index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userform", new UserForm());
        return "register";
    }

    @PostMapping("/addUser")
    public String addNewUser(@Valid UserForm userForm) {
        User user = new User(userForm.getName(), userForm.getPhone(), userForm.getEmail(), userForm.getPassword());
        userService.save(user);

        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
