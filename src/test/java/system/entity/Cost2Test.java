package system.entity;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

class Cost2Test {
    private static EntityManagerFactory emf;

    @Test
    @SuppressWarnings("unchecked")
    void selectAllCost() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        List<Cost> costs = entityManager.createQuery("from costs ").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        for (Cost cost : costs) {
            System.out.println(cost.getId() + " " + cost.getValue() + " " + cost.getCategory() + " " + cost.getComment());
        }
    }
}
