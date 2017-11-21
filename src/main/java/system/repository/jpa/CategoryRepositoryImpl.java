package system.repository.jpa;

import org.springframework.stereotype.Repository;
import system.entity.Category;
import system.repository.CategoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public Collection<Category> findAllCategory() {
        entityManager.getTransaction();
        List<Category> categoryList = entityManager.createQuery("select category from category ").getResultList();
        entityManager.getTransaction().commit();
        return categoryList;


    }
}
