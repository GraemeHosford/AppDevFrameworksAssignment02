package graeme.hosford.rob.morgan.assignment2.data.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Job")
public class Job {

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

    public Job() {
    }

    public Job(String jobName, String jobDescription, LocalDate jobPublishedDate, boolean active) {
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.jobPublishedDate = jobPublishedDate;
        this.active = active;
    }

    @JoinTable
    @OneToMany
    private List<Bid> jobBids = new ArrayList<>();

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
}
