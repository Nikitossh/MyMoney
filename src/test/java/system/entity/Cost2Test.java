package system.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

class Cost2Test {
    @PersistenceContext
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("bla");

    @BeforeAll
    static void init() {
        System.out.println("Start");
    }



    @Test
    @SuppressWarnings("unchecked")
    void selectAllCost() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        List<Cost> costs = entityManager.createQuery("select c from costs c " ).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        for (Cost cost : costs) {
            System.out.println(cost.getId() + " " + cost.getValue() + " " + cost.getCategory() + " " + cost.getComment());
        }
    }
}
