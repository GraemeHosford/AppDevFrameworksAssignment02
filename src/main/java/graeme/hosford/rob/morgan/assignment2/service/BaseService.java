package graeme.hosford.rob.morgan.assignment2.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

abstract class BaseService<DAO extends JpaRepository<Entity, Long>, Entity> {

    protected DAO dao;

    BaseService(DAO dao) {
        this.dao = dao;
    }

    Entity getEntityById(long id) {
        Optional<Entity> entity = dao.findById(id);
        return entity.orElse(null);
    }

    private void saveEntity(Entity entity) {
        dao.save(entity);
    }

    @SafeVarargs
    final void saveEntities(Entity... entities) {
        for (Entity e : entities) {
            saveEntity(e);
        }
    }

    List<Entity> getAllEntities() {
        return dao.findAll();
    }

}
