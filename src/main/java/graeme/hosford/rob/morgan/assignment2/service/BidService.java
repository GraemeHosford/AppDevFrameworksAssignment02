package graeme.hosford.rob.morgan.assignment2.service;

import graeme.hosford.rob.morgan.assignment2.data.entities.Bid;
import org.springframework.stereotype.Service;

@Service
public interface BidService {

    Bid getBidById(long bidId);

}
