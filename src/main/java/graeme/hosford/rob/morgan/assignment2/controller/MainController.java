package graeme.hosford.rob.morgan.assignment2.controller;

import graeme.hosford.rob.morgan.assignment2.controller.form.BidForm;
import graeme.hosford.rob.morgan.assignment2.controller.form.JobForm;
import graeme.hosford.rob.morgan.assignment2.controller.form.RegisterForm;
import graeme.hosford.rob.morgan.assignment2.data.entities.Bid;
import graeme.hosford.rob.morgan.assignment2.data.entities.Job;
import graeme.hosford.rob.morgan.assignment2.data.entities.Role;
import graeme.hosford.rob.morgan.assignment2.data.entities.User;
import graeme.hosford.rob.morgan.assignment2.service.BidService;
import graeme.hosford.rob.morgan.assignment2.service.JobService;
import graeme.hosford.rob.morgan.assignment2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
public class MainController {

    private JobService jobService;
    private UserService userService;
    private BidService bidService;

    @Autowired
    public MainController(JobService jobService, UserService userService, BidService bidService) {
        this.jobService = jobService;
        this.userService = userService;
        this.bidService = bidService;
    }

    @GetMapping(value = {"/", "/index"})
    public String indexMapping(Model model, Principal user) {
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

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userform", new RegisterForm());

        return "register";
    }

    @PostMapping(value = "/registerUser")
    public String addNewUser(@Valid RegisterForm registerForm, BindingResult binding, Model model, Principal prin) {
        if (binding.hasErrors()) {
            return "redirect:register";
        } else {
            User user = new User(registerForm.getName(), registerForm.getPhone(), registerForm.getEmail(),
                    registerForm.getPassword(), new Role(registerForm.getEmail(), "ROLE_USER"));
            userService.save(user);
            return "redirect:" + indexMapping(model, prin);
        }
    }

    @GetMapping("/newJob")
    public String newJob(Model model) {
        model.addAttribute("jobForm", new JobForm());
        return "newJob";
    }

    @PostMapping("/addJob")
    public String addNewJob(@Valid JobForm jobForm, Model model, Principal user) {
        Job job = new Job(jobForm.getJobName(), jobForm.getJobDescription(), LocalDate.now(), userService.findByEmail(user.getName()));
        jobService.save(job);

        return "redirect:" + indexMapping(model, user);
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/job/{jobId}")
    public String showJob(Model model, @PathVariable("jobId") long jobId) {
        Job job = jobService.getJobById(jobId);

        BidForm bidForm = new BidForm();

        model.addAttribute("job", job);
        model.addAttribute("bidForm", bidForm);
        return "job";
    }

    @PostMapping("/makeBid/{jobId}")
    public String makeBid(@Valid BidForm bidForm, Model model, Principal user, @PathVariable long jobId) {
        Job job = jobService.getJobById(jobId);
        User bidder = userService.findByEmail(user.getName());
        Bid bid = new Bid(bidForm.getAmount(), bidder, job);

        bidService.save(bid);

        return showJob(model, jobId);
    }

}
