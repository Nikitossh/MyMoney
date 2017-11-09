package system.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

class BudgetTest {
    private static SessionFactory sessionFactory;

    @BeforeAll
    static void init() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    @AfterAll
    static void done() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Test
    void testBudget() {
        // Создаем сессию с помощью фабрики
        Session session = sessionFactory.openSession();
        // Начинаем транзакцию
        session.beginTransaction();
        List result = session.createQuery("from budget ").list();
        for (Budget budget : (List<Budget>) result) {
            System.out.println(budget.getId() + "  " + budget.getAmount() + "  " + budget.getCategory() + budget.getComment());
        }
        // Коммитим транзакцию, можем дописать запросы еще до этого и они будут исполнены все или не исполнено ни одного
        session.getTransaction().commit();
        // Закрываем сессию
        session.close();
    }

}