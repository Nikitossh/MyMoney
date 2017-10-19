package system.entity;

//import junit.framework.TestCase;
import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BudgetTest extends TestCase {
    private SessionFactory sessionFactory;

    @Override
    protected void setUp() throws Exception{
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

    @Override
    protected void tearDown() throws Exception{
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public void testBudget() {
        // Создаем сессию с помощью фабрики
        Session session = sessionFactory.openSession();
        // Начинаем транзакцию
        session.beginTransaction();
        List result = session.createQuery("from budget ").list();
        for (Budget budget : (List<Budget>) result) {
            System.out.println(budget.getId() + "  " + budget.getAmount() + "  " + budget.getCategory_id() + budget.getComment());
        }
        // Коммитим транзакцию, можем дописать запросы еще до этого и они будут исполнены все или не исполнено ни одного
        session.getTransaction().commit();
        // Закрываем сессию
        session.close();
    }

}