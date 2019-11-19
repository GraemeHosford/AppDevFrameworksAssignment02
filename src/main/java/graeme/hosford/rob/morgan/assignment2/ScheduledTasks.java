package graeme.hosford.rob.morgan.assignment2;

import graeme.hosford.rob.morgan.assignment2.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private final JobService jobService;

    @Autowired
    public ScheduledTasks(JobService jobService) {
        this.jobService = jobService;
    }

    /* At midnight every day of every month of every year */
    @Scheduled(cron = "0 0 0 * * *")
    public void updateJobActiveTimes() {
        jobService.updateAllJobsActiveStatus();
    }

}
