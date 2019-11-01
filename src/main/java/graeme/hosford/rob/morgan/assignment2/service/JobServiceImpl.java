package graeme.hosford.rob.morgan.assignment2.service;

import graeme.hosford.rob.morgan.assignment2.data.dao.JobDAO;
import graeme.hosford.rob.morgan.assignment2.data.entities.Job;
import org.springframework.beans.factory.annotation.Autowired;

public class JobServiceImpl extends BaseService<JobDAO, Job> implements JobService {

    @Autowired
    public JobServiceImpl(JobDAO jobDAO) {
        super(jobDAO);
    }

    @Override
    public Job getJobById(long jobId) {
        return getEntityById(jobId);
    }
}
