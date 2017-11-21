package system.entity;

import java.util.ArrayList;
import java.util.List;

public class Categories {
    private List<Category> categories;

    public List<Category> getCategoriesList() {
        if (categories == null) {
            categories = new ArrayList<>();
        }
            return categories;

    }
}
