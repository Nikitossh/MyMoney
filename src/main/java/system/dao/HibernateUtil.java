package system.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static SessionFactory sessionFactory = null;

    static {
        Configuration cfg = new Configuration().configure();
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
//                .applySetting();
//
//        sessionFactory = cfg.buildSessionFactory((builder.build()));
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}