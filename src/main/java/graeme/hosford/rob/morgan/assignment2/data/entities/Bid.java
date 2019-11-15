package graeme.hosford.rob.morgan.assignment2.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Bid")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bidId;

    @Column(name = "BidAmount", nullable = false)
    private double bidAmount;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnore
    private Job jobRef;

    public Bid() {
    }

    public Bid(double bidAmount, User user, Job job) {
        this.bidAmount = bidAmount;
        this.user = user;
        this.jobRef = job;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Job getJobRef() {
        return jobRef;
    }

    public void setJobRef(Job jobRef) {
        this.jobRef = jobRef;
    }
}
