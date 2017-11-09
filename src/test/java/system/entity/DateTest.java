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

class DateTest {
    private static SessionFactory factory;

    @BeforeAll
    static void beforeAll() {
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            // Получаем SessionFactory
            factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    @AfterAll
     static void afterAll() {
        if (factory != null) {
            factory.close();
        }
    }

    @Test
    void testDate() {
        Session session = factory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from date").list();
        for (Date date : (List<Date>) result) {
            System.out.println("Id: " + date.getId() + " date:  " + date.getDate() );
        }
        session.getTransaction().commit();
        session.close();
    }

}