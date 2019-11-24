package graeme.hosford.rob.morgan.assignment2.service;

import graeme.hosford.rob.morgan.assignment2.data.dao.JobDAO;
import graeme.hosford.rob.morgan.assignment2.data.entities.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl extends BaseService<JobDAO, Job> implements JobService {

    @Autowired
    public JobServiceImpl(JobDAO jobDAO) {
        super(jobDAO);
    }

    @Override
    public Job getJobById(long jobId) {
        return getEntityById(jobId);
    }

    @Override
    public List<Job> getAllJobs() {
        return getAllEntities();
    }

    @Override
    public void updateAllJobsActiveStatus() {
        List<Job> activeJobs = getActiveJobs();

        for (Job job : activeJobs) {
            job.updateActiveState();
        }

        /* Save all jobs again to update their status in database */
        save(activeJobs.toArray(new Job[0]));
    }

    @Override
    public List<Job> getActiveJobs() {
        return dao.getJobByActive(true);
    }

    @Override
    public void save(Job... jobs) {
        saveEntities(jobs);
    }
}
