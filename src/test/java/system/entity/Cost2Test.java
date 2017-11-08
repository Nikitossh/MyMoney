package system.entity;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

class Cost2Test extends TestCase{
    private EntityManagerFactory emf;

    @Test
    @SuppressWarnings("unchecked")
    void selectAllCost() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        List<Cost> costs = entityManager.createQuery("select c from costs c join c.category_id join c.date_id").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
//        for (Cost cost : costs) {
//            System.out.println(cost.getId() + " " + cost.getValue() + " " + cost.getCategory_id() + " " + cost.getComment());
//        }
    }
}
