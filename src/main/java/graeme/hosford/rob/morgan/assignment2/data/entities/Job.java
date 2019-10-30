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
}
