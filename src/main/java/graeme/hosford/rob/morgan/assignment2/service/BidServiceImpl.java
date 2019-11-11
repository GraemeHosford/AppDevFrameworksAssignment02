package graeme.hosford.rob.morgan.assignment2.service;

import graeme.hosford.rob.morgan.assignment2.data.dao.BidDAO;
import graeme.hosford.rob.morgan.assignment2.data.entities.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidServiceImpl extends BaseService<BidDAO, Bid> implements BidService {

    @Autowired
    public BidServiceImpl(BidDAO bidDAO) {
        super(bidDAO);
    }

    @Override
    public Bid getBidById(long bidId) {
        return getEntityById(bidId);
    }

    @Override
    public boolean makeBid(long bidId, double bidAmount) {
        Bid bid = getEntityById(bidId);

        if (bidAmount < bid.getBidAmount()) {
            bid.setBidAmount(bidAmount);
            save(bid);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void save(Bid... bids) {
        saveEntities(bids);
    }
}
