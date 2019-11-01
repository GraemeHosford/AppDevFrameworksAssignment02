package graeme.hosford.rob.morgan.assignment2.data.dao;

import graeme.hosford.rob.morgan.assignment2.data.entities.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidDAO extends JpaRepository<Bid, Long> {
}
