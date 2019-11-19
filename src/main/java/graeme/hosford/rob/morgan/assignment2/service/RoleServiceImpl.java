package graeme.hosford.rob.morgan.assignment2.service;

import graeme.hosford.rob.morgan.assignment2.data.dao.RoleDAO;
import graeme.hosford.rob.morgan.assignment2.data.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseService<RoleDAO, Role> implements RoleService {

    @Autowired
    public RoleServiceImpl(RoleDAO dao) {
        super(dao);
    }

    @Override
    public void save(Role... roles) {
        saveEntities(roles);
    }
}
