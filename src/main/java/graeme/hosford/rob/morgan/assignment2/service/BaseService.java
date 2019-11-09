package graeme.hosford.rob.morgan.assignment2.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

abstract class BaseService<DAO extends JpaRepository<Entity, Long>, Entity> {

    /* This may need to be changed to private at some point
    but easier to leave like this for now for sake of convenience */
    protected DAO dao;

    BaseService(DAO dao) {
        this.dao = dao;
    }

    Entity getEntityById(long id) {
        Optional<Entity> entity = dao.findById(id);
        return entity.orElse(null);
    }

    void deleteEntityById(long id) {
        dao.deleteById(id);
    }

    void deleteByEntityByObject(Entity entity) {
        dao.delete(entity);
    }

    boolean entityExists(long id) {
        return dao.existsById(id);
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
