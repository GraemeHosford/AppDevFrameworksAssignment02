package graeme.hosford.rob.morgan.assignment2.controller;

import graeme.hosford.rob.morgan.assignment2.service.BidService;
import graeme.hosford.rob.morgan.assignment2.service.JobService;
import graeme.hosford.rob.morgan.assignment2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class JobsController {

    private JobService jobService;
    private UserService userService;
    private BidService bidService;

    @Autowired
    public JobsController(JobService jobService, UserService userService, BidService bidService) {
        this.jobService = jobService;
        this.userService = userService;
        this.bidService = bidService;
    }

}
