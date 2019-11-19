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
        List<Job> all = getAllJobs();

        for (Job job : all) {
            job.updateActiveState();
        }
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
