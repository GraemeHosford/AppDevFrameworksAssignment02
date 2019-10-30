package graeme.hosford.rob.morgan.assignment2.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long jobId;

    @Column(name = "JobName")
    private String jobName;

    @Column(name = "JobDescription")
    private String jobDescription;

    @Column(name = "JobPublishedDate")
    private LocalDate jobPublishedDate;

}
