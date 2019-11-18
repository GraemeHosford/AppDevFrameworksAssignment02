package graeme.hosford.rob.morgan.assignment2.controller;

import graeme.hosford.rob.morgan.assignment2.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BidController {

    private BidService bidService;

    @Autowired
    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

}
