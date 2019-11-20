package graeme.hosford.rob.morgan.assignment2.controller;

import graeme.hosford.rob.morgan.assignment2.controller.form.BidForm;
import graeme.hosford.rob.morgan.assignment2.controller.form.JobForm;
import graeme.hosford.rob.morgan.assignment2.data.entities.Job;
import graeme.hosford.rob.morgan.assignment2.service.JobService;
import graeme.hosford.rob.morgan.assignment2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;

@Controller
public class JobsController {

    private JobService jobService;
    private UserService userService;

    @Autowired
    public JobsController(JobService jobService, UserService userService) {
        this.jobService = jobService;
        this.userService = userService;
    }

    @GetMapping("/newJob")
    public String newJob(Model model) {
        model.addAttribute("jobForm", new JobForm());
        return "newJob";
    }

    @PostMapping("/addJob")
    public String addNewJob(@Valid JobForm jobForm, Principal user) {
        Job job = new Job(jobForm.getJobName(), jobForm.getJobDescription(), LocalDate.now(), userService.findByEmail(user.getName()));
        jobService.save(job);

        return "redirect:/";
    }

    @GetMapping("/job/{jobId}")
    public String showJob(Model model, Principal user, @PathVariable("jobId") long jobId) {
        Job job = jobService.getJobById(jobId);

        BidForm bidForm = new BidForm();

        model.addAttribute("job", job);
        model.addAttribute("bidForm", bidForm);

        if (user != null) {
            String email = user.getName();
            long userId = userService.findByEmail(email).getUserId();
            model.addAttribute("userid", userId);
        } else {
            model.addAttribute("userid", -1);
        }

        return "job";
    }

}
