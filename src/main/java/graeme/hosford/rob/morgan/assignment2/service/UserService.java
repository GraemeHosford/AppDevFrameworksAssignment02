package graeme.hosford.rob.morgan.assignment2.service;

import graeme.hosford.rob.morgan.assignment2.data.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User getUserById(long userId);

}