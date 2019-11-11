package graeme.hosford.rob.morgan.assignment2.controller;

import graeme.hosford.rob.morgan.assignment2.data.entities.Job;
import graeme.hosford.rob.morgan.assignment2.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class JobsController {

    private JobService jobService;

    @Autowired
    public JobsController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public String showAllJobs(Model model) {
        List<Job> jobs = jobService.getAllJobs();
        model.addAttribute("jobs", jobs);
        return "jobs";
    }

}
