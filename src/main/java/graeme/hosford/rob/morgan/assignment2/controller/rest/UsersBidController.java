package graeme.hosford.rob.morgan.assignment2.controller.rest;

import graeme.hosford.rob.morgan.assignment2.data.dao.UserDAO;
import graeme.hosford.rob.morgan.assignment2.data.entities.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersBidController {

    private UserDAO userDAO;

    @Autowired
    public UsersBidController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("userbid/{id}")
    public List<Bid> getUserBids(@PathVariable(name = "id") long userId) {
        return userDAO.getUserBids(userId);
    }

}
