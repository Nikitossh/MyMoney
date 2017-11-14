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

    //private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<Cost> findAll() {
        EntityManager entityManager = emf.createEntityManager();

//        return this.entityManager.createQuery("from costs ").getResultList();
        entityManager.getTransaction().begin();
        List<Cost> costs = entityManager.createQuery("select c from costs c " ).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
//        for (Cost cost : costs) {
//            System.out.println(cost.getId() + " " + cost.getValue() + " " + cost.getCategory() + " " + cost.getComment());
//        }
        return costs;
    }
}
