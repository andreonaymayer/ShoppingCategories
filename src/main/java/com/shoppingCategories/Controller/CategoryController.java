package com.shoppingCategories.Controller;

import com.shoppingCategories.Entities.Category;
import com.shoppingCategories.Services.CategoryService;
import java.util.List;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@EnableAutoConfiguration
@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category/")
    public List<Category> listCategoryByName(@RequestParam(required = false, defaultValue = "") String name) {
        return categoryService.getCategoriesOrByName(name);
    }

    @RequestMapping("/category1")
    @ResponseBody
    public List<Category> listCategoryByName1(@RequestParam(required = false, defaultValue = "") String name) {
        return categoryService.getCategoriesOrByName(name);
    }

    @RequestMapping("/home")
    @ResponseBody
    public String home() {
        return "Home, welcome!";
    }

    @PostMapping("/category/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCategory(@RequestBody Category category) {

        categoryService.newCategory(category);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> categoryListById(@PathVariable String id) {
        Category category = categoryService.getCategoryByID(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(category);
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