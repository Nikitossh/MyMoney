package system.entity;

import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DateTest extends TestCase {
    SessionFactory factory = null;

    @Override
    protected void setUp() {
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

    @Override
     protected void tearDown() {
        if (factory != null) {
            factory.close();
        }
    }

    public void testDate() {
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