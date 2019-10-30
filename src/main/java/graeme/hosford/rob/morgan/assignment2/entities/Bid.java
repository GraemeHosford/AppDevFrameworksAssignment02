package graeme.hosford.rob.morgan.assignment2.entities;

import javax.persistence.*;

@Entity
@Table(name = "Bid")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bidId;

    @Column(name = "BidAmount")
    private double bidAmount;

}
