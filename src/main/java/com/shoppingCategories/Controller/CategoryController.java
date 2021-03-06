package com.shoppingCategories.Controller;

import com.shoppingCategories.Entities.Category;
import com.shoppingCategories.Services.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@EnableAutoConfiguration
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category/")
    @ResponseBody
    public List<Category> listCategoryByName(@RequestParam(required = false, defaultValue = "") String name) {
        return categoryService.getCategoriesByName(name);
    }


    @PostMapping("/category/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCategory(@RequestBody Category category) {
        try {
            categoryService.newCategory(category);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Id already exists");
        }

    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> categoryListById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(categoryService.getCategoryByID(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/category/{id}")
    public @ResponseBody
    ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable String id) {
        try {
            return ResponseEntity.ok(categoryService.updateCategory(category, id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/category/{id}")
    public void categoryDelete(@PathVariable String id) {
        try {
            categoryService.deleteCategory(id);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found");
        }
    }
}