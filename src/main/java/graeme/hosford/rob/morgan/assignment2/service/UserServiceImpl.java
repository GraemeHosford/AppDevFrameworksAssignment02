package graeme.hosford.rob.morgan.assignment2.service;

import graeme.hosford.rob.morgan.assignment2.data.dao.UserDAO;
import graeme.hosford.rob.morgan.assignment2.data.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends BaseService<UserDAO, User> implements UserService {

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        super(userDAO);
    }

    @Override
    public User getUserById(long userId) {
        return getEntityById(userId);
    }

    @Override
    public User loginUser(String email, String password) {
        Optional<User> user = dao.getUserAccount(email, password);
        return user.orElse(null);
    }

    @Override
    public User findByEmail(String email) {
        return dao.getUserFromEmail(email);
    }

    @Override
    public void save(User... users) {
        saveEntities(users);
    }
}
