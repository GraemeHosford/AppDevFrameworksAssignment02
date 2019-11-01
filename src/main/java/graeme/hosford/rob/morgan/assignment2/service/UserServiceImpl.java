package graeme.hosford.rob.morgan.assignment2.service;

import graeme.hosford.rob.morgan.assignment2.data.dao.UserDAO;
import graeme.hosford.rob.morgan.assignment2.data.entities.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl extends BaseService<UserDAO, User> implements UserService {

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        super(userDAO);
    }

    @Override
    public User getUserById(long userId) {
        return getEntityById(userId);
    }
}
