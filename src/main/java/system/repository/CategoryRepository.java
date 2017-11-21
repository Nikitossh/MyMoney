package system.repository;

import system.entity.Category;

import java.util.Collection;

public interface CategoryRepository {
    Collection<Category> findAllCategory();
}
