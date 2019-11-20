package graeme.hosford.rob.morgan.assignment2.controller;

import graeme.hosford.rob.morgan.assignment2.data.entities.Job;
import graeme.hosford.rob.morgan.assignment2.service.JobService;
import graeme.hosford.rob.morgan.assignment2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
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
    public String index(Model model, Principal user) {
        List<Job> jobs = jobService.getAllJobs();
        model.addAttribute(jobs);

        if (user != null) {
            String email = user.getName();
            long userId = userService.findByEmail(email).getUserId();
            model.addAttribute("userid", userId);
        } else {
            model.addAttribute("userid", -1);
        }

        return "index";
    }

}
