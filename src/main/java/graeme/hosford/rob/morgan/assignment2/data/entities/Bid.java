package graeme.hosford.rob.morgan.assignment2.data.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Bid")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bidId;

    @Column(name = "BidAmount", nullable = false)
    private double bidAmount;

    @ManyToOne
    List<User> userBids = new ArrayList<>();

    public Bid() {
    }

    public long getBidId() {
        return bidId;
    }

    public void setBidId(long bidId) {
        this.bidId = bidId;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }
}
