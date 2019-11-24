package graeme.hosford.rob.morgan.assignment2.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Entity
@Table(name = "Job")
public class Job {

    private static final int JOB_ACTIVE_DAYS = 20;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long jobId;

    @Column(name = "JobName", nullable = false)
    private String jobName;

    @Column(name = "JobDescription", nullable = false)
    private String jobDescription;

    @Column(name = "JobPublishedDate", nullable = false)
    private LocalDate jobPublishedDate;

    @Column(name = "active", nullable = false)
    private boolean active;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnore
    private User userRef;

    @OneToMany(mappedBy = "jobRef")
    private List<Bid> jobBids = new ArrayList<>();

    public Job() {
    }

    public Job(String jobName, String jobDescription, LocalDate jobPublishedDate, User jobOwner) {
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.jobPublishedDate = jobPublishedDate;
        this.userRef = jobOwner;

        /* Calling this basically the same as just setting active to true at the point the job is created.
         * Better to just keep it all in the one method though. */
        updateActiveState();
    }

    public void updateActiveState() {
        this.active = DAYS.between(jobPublishedDate, LocalDate.now()) <= JOB_ACTIVE_DAYS;
    }

    public Bid getLowestBid() {
        /* Only bids lower than the last can be entered, therefore the lowest is always the last in the list */
        return jobBids.get(jobBids.size() - 1);
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public LocalDate getJobPublishedDate() {
        return jobPublishedDate;
    }

    public void setJobPublishedDate(LocalDate jobPublishedDate) {
        this.jobPublishedDate = jobPublishedDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User getUserRef() {
        return userRef;
    }

    public void setUserRef(User userRef) {
        this.userRef = userRef;
    }

    public List<Bid> getJobBids() {
        return jobBids;
    }

    public void setJobBids(List<Bid> jobBids) {
        this.jobBids = jobBids;
    }
}
