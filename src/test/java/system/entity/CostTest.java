/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2010, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package system.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


/**
 * Test for connection and some queries with table bablo.costs
 * @author Nikita Shesterikov
 */

class CostTest {
    private static SessionFactory sessionFactory;


    @BeforeAll
    static void init() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
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
    @SuppressWarnings({"unchecked"})
    void testBasicUsage() {

        // Pull all values from database
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        // Name "costs" in database with lowercase must be the the same there
        List result = session.createQuery("from costs ").list();
        for (Cost cost : (List<Cost>) result) {
            System.out.println(cost.getId() + " " + cost.getValue() + " " + cost.getCategory() + " " + cost.getComment());
        }
        session.getTransaction().commit();
        session.close();
    }

    @Test
    void testSelectSomeCosts() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(
                "select c " +
                "from costs c " +
                "where c.comment like :comment")
                .setParameter("comment", "s%");
        session.beginTransaction();
        List result = query.list();
        for (Cost cost : (List<Cost>) result) {
            System.out.println(cost.getId() + " " + cost.getValue() + " " + cost.getCategory() + " " + cost.getComment());
        }
        session.getTransaction().commit();
        session.close();
    }

    @Test
    // NativeQuery
    public void testGetMonthCosts() {
        Session session = sessionFactory.openSession();
        List<Object[]> costs = session.createNativeQuery("SELECT category.category, SUM(costs.value) AS value\n" +
                "FROM costs\n" +
                "INNER JOIN category ON costs.category_id=category.id\n" +
                "INNER JOIN date ON costs.date_id=date.id\n" +
                "WHERE MONTH(date)=MONTH(NOW())\n" +
                "AND YEAR(date)=YEAR(NOW())\n" +
                "GROUP BY category;").getResultList();
        session.beginTransaction();
        for (Object[] objects : costs) {
            System.out.println(objects.toString());
        }
        session.getTransaction().commit();
        session.close();
    }




}