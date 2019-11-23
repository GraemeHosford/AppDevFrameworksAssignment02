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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String makeBid(@ModelAttribute @Valid BidForm bidForm,
                          Principal user, @PathVariable long jobId,
                          RedirectAttributes redirectAttributes) {
        if (bidForm.getAmount() <= 0) {
            redirectAttributes.addFlashAttribute("negativeBid", true);
            return "redirect:/job/" + jobId;
        }

        Job job = jobService.getJobById(jobId);

        if (bidForm.getAmount() >= job.getLowestBid().getBidAmount()) {
            /* Newly entered bid is not lower than previous lowest bid so don't save this one */
            redirectAttributes.addFlashAttribute("bidNotLowEnough", true);
            return "redirect:/job/" + jobId;
        }

        User bidder = userService.findByEmail(user.getName());
        Bid bid = new Bid(bidForm.getAmount(), bidder, job);

        bidService.save(bid);

        return "redirect:/job/" + jobId;
    }

}
