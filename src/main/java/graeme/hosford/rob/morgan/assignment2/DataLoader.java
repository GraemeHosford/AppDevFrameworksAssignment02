package graeme.hosford.rob.morgan.assignment2;

import graeme.hosford.rob.morgan.assignment2.data.entities.Bid;
import graeme.hosford.rob.morgan.assignment2.data.entities.Job;
import graeme.hosford.rob.morgan.assignment2.data.entities.Role;
import graeme.hosford.rob.morgan.assignment2.data.entities.User;
import graeme.hosford.rob.morgan.assignment2.service.BidService;
import graeme.hosford.rob.morgan.assignment2.service.JobService;
import graeme.hosford.rob.morgan.assignment2.service.RoleService;
import graeme.hosford.rob.morgan.assignment2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {

    private BidService bidService;
    private JobService jobService;
    private UserService userService;
    private RoleService roleService;
    private PasswordEncoder passEncoder;

    @Autowired
    public DataLoader(BidService bidService, JobService jobService,
                      UserService userService, RoleService roleService,
                      PasswordEncoder passEncoder) {
        this.bidService = bidService;
        this.jobService = jobService;
        this.userService = userService;
        this.roleService = roleService;
        this.passEncoder = passEncoder;
    }

    @Override
    public void run(ApplicationArguments args) {
        Role role1 = new Role("graeme.hosford@mycit.ie", Role.USER);
        Role role2 = new Role("rob.morgan@mycit.ie", Role.USER);
        Role role3 = new Role("j.smith@gmail.com", Role.USER);
        Role api = new Role("apiuser@mycit.ie", Role.API);
        roleService.save(role1, role2, role3, api);

        User user1 = new User("Graeme Hosford", "0852336922", "graeme.hosford@mycit.ie", passEncoder.encode("SomePassword"), role1);
        User user2 = new User("Robert Morgan", "0873755491", "rob.morgan@mycit.ie", passEncoder.encode("Password1"), role2);
        User user3 = new User("John Smith", "0856671935", "j.smith@gmail.com", passEncoder.encode("JohnSmithPassword"), role3);
        User apiUser = new User("API Consumer", "0000000000", "apiuser@mycit.ie", passEncoder.encode("password"), api);

        userService.save(user1, user2, user3, apiUser);

        Job job1 = new Job("Fix kitchen", "Kitchen needs fixing", LocalDate.now(), user2);
        Job job2 = new Job("Tile bathroom", "tile the bathroom", LocalDate.of(2019, 9, 23), user3);
        Job job3 = new Job("DO some other thing", "Default job", LocalDate.now(), user1);

        jobService.save(job1, job2, job3);

        Bid bid1 = new Bid(200.0, user1, job1);
        Bid bid2 = new Bid(134.34, user2, job2);
        Bid bid3 = new Bid(76.18, user3, job3);
        Bid bid4 = new Bid(150, user2, job1);

        bidService.save(bid1, bid2, bid3, bid4);

    }
}
