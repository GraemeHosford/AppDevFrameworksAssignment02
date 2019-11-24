package graeme.hosford.rob.morgan.assignment2.controller.form;

public class BidForm {

    /* Error handling not included here. Done using flash attributes in BidController */
    private double amount;

    private long bidMaker;

    private long job;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getBidMaker() {
        return bidMaker;
    }

    public void setBidMaker(long bidMaker) {
        this.bidMaker = bidMaker;
    }

    public long getJob() {
        return job;
    }

    public void setJob(long job) {
        this.job = job;
    }
}
