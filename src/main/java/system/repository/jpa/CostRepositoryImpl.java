package system.repository.jpa;

import org.springframework.stereotype.Repository;
import system.entity.Cost;
import system.repository.CostRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class CostRepositoryImpl implements CostRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Cost> findAll() {
        return this.entityManager.createQuery("select costs from costs ").getResultList();
    }
}
