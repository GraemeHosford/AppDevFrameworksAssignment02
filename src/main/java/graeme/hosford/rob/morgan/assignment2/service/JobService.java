package graeme.hosford.rob.morgan.assignment2.service;

import graeme.hosford.rob.morgan.assignment2.data.entities.Job;

import java.util.List;

public interface JobService {

    Job getJobById(long jobId);

    List<Job> getActiveJobs();

    void save(Job... jobs);

}
