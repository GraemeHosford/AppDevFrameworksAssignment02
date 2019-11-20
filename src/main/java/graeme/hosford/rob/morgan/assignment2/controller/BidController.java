package graeme.hosford.rob.morgan.assignment2.controller;

import graeme.hosford.rob.morgan.assignment2.controller.form.BidForm;
import graeme.hosford.rob.morgan.assignment2.data.entities.Bid;
import graeme.hosford.rob.morgan.assignment2.data.entities.Job;
import graeme.hosford.rob.morgan.assignment2.data.entities.User;
import graeme.hosford.rob.morgan.assignment2.service.BidService;
import graeme.hosford.rob.morgan.assignment2.service.JobService;
import graeme.hosford.rob.morgan.assignment2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class BidController {

    private BidService bidService;
    private UserService userService;
    private JobService jobService;

    @Autowired
    public BidController(BidService bidService, UserService userService, JobService jobService) {
        this.bidService = bidService;
        this.userService = userService;
        this.jobService = jobService;
    }

    @PostMapping("/makeBid/{jobId}")
    public String makeBid(@Valid BidForm bidForm, Principal user, @PathVariable long jobId) {
        Job job = jobService.getJobById(jobId);
        User bidder = userService.findByEmail(user.getName());
        Bid bid = new Bid(bidForm.getAmount(), bidder, job);

        bidService.save(bid);

        return "redirect:/job/" + jobId;
    }

}
