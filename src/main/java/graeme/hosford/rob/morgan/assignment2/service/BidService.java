package graeme.hosford.rob.morgan.assignment2.service;

import graeme.hosford.rob.morgan.assignment2.data.entities.Bid;
import graeme.hosford.rob.morgan.assignment2.data.entities.Job;
import graeme.hosford.rob.morgan.assignment2.data.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface BidService {

    Bid getBidById(long bidId);

    void makeBid(double bidAmount, Job job, User user);

    void save(Bid... bids);

}
