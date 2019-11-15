package graeme.hosford.rob.morgan.assignment2.controller;

import graeme.hosford.rob.morgan.assignment2.controller.form.JobForm;
import graeme.hosford.rob.morgan.assignment2.controller.form.UserForm;
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
import java.time.LocalDate;
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
        User user = userService.getCurrentUser();
        model.addAttribute(jobs);

        if (user != null) {
            model.addAttribute(user);
        } else {
            model.addAttribute(new User());
        }
        return "index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userform", new UserForm());
        return "register";
    }

    @PostMapping("/registerUser")
    public String addNewUser(@Valid UserForm userForm, Model model) {
        User user = new User(userForm.getName(), userForm.getPhone(), userForm.getEmail(), userForm.getPassword());
        userService.setCurrentUser(user);

        return indexMapping(model);
    }

    @GetMapping("/newJob")
    public String newJob(Model model) {
        model.addAttribute("jobForm", new JobForm());
        return "newJob";
    }

    @PostMapping("/addJob")
    public String addNewJob(@Valid JobForm jobForm, Model model) {
        Job job = new Job(jobForm.getJobName(), jobForm.getJobDescription(), LocalDate.now(), userService.getCurrentUser());
        jobService.save(job);

        return indexMapping(model);
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
