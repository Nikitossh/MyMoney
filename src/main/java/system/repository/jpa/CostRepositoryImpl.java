package system.repository.jpa;

import system.entity.Cost;
import system.repository.CostRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

public class CostRepositoryImpl implements CostRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @SuppressWarnings("uncheked")
    public Collection<Cost> findAll() {
        return this.entityManager.createQuery("select c costs as c from costs ").getResultList();
    }
}
