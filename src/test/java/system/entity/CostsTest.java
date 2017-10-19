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

import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


/**
 * Test for connection and some queries with table bablo.costs
 * @author Nikita Shesterikov
 */
public class CostsTest extends TestCase {
    private SessionFactory sessionFactory;

    @Override
    protected void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
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

    @Override
    protected void tearDown() throws Exception {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @SuppressWarnings({"unchecked"})
    public void testBasicUsage() {
        // Pull all values from database
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        // Name "costs" in database with lowercase must be the the same there
        List result = session.createQuery("from costs ").list();
        for (Costs costs : (List<Costs>) result) {
            System.out.println(costs.getId() + " " + costs.getValue() + " " + costs.getCategory_id() + " " + costs.getComment());
        }
        session.getTransaction().commit();

        // And one more query
        session.beginTransaction();
        List result2 = session.createQuery("SELECT c FROM costs AS c JOIN category.id AS ca WHERE category.category='food' ").list();
        for (Costs costs2 : (List<Costs>) result2) {
            System.out.println(costs2.getValue() + costs2.getComment());
        }
        session.getTransaction().commit();
        session.close();
    }


}