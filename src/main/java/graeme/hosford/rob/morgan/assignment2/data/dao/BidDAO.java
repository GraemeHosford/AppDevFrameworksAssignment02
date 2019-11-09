package graeme.hosford.rob.morgan.assignment2.data.dao;

import graeme.hosford.rob.morgan.assignment2.data.entities.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidDAO extends JpaRepository<Bid, Long> {

    @Query("SELECT b FROM Bid b JOIN User u ON b.user = u WHERE u.userId = :id")
    List<Bid> getUserBids(@Param("id") long userid);

}
