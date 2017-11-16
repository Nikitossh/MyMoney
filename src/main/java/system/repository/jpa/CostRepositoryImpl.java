package system.repository.jpa;

import org.springframework.stereotype.Repository;
import system.entity.Cost;
import system.repository.CostRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

@Repository
public class CostRepositoryImpl implements CostRepository {

    @PersistenceContext
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("bla");
    private EntityManager em = emf.createEntityManager();

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Cost> findAll() {

        em.getTransaction().begin();
        List<Cost> costs = em.createQuery("select c from costs c " ).getResultList();
        em.getTransaction().commit();
        em.close();
        return costs;
    }

}
