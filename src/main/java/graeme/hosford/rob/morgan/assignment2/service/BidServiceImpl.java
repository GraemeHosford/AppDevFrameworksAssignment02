package graeme.hosford.rob.morgan.assignment2.service;

import graeme.hosford.rob.morgan.assignment2.data.dao.BidDAO;
import graeme.hosford.rob.morgan.assignment2.data.entities.Bid;
import org.springframework.beans.factory.annotation.Autowired;

public class BidServiceImpl extends BaseService<BidDAO, Bid> implements BidService {

    @Autowired
    public BidServiceImpl(BidDAO bidDAO) {
        super(bidDAO);
    }

    @Override
    public Bid getBidById(long bidId) {
        return getEntityById(bidId);
    }
}
