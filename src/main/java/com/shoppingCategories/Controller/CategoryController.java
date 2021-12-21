package com.shoppingCategories.Controller;

import com.shoppingCategories.Entities.Category;
import com.shoppingCategories.Services.CategoryService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category/")
    public List<Category> listCommunityByName(@RequestParam(required = false, defaultValue = "") String name) {
        return categoryService.getCategoriesOrByName(name);
    }

    @PostMapping("/category/")
    @ResponseStatus(HttpStatus.CREATED)
    public void mongoAddCommunity(@RequestBody Category category) {

        categoryService.newCategory(category);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> communityListById(@PathVariable String id) {
        Category category = categoryService.getCategoryByID(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(category);
    }
}
