package graeme.hosford.rob.morgan.assignment2.service;

import graeme.hosford.rob.morgan.assignment2.data.entities.Job;
import org.springframework.stereotype.Service;

@Service
public interface JobService {

    Job getJobById(long jobId);

}
