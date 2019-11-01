package graeme.hosford.rob.morgan.assignment2.data.dao;

import graeme.hosford.rob.morgan.assignment2.data.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDAO extends JpaRepository<Job, Long> {
}
