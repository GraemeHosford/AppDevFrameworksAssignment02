package graeme.hosford.rob.morgan.assignment2.data.dao;

import graeme.hosford.rob.morgan.assignment2.data.entities.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidDAO extends JpaRepository<Bid, Long> {
}
