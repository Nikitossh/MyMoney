package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import system.entity.Categories;
import system.service.CategoryService;

import java.util.Map;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/all")
    public String showAllCategory(Map<String, Object> model) {
        Categories categories = new Categories();
        categories.getCategoriesList().addAll(this.categoryService.findAllCategory());
        model.put("category", categories);
        return "category/categoryAll";
    }

}
