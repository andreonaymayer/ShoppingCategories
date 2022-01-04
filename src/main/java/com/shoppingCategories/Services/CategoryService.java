package com.shoppingCategories.Services;

import com.shoppingCategories.Entities.Category;
import com.shoppingCategories.Repository.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired

    private CategoryRepository categoryRepo;

    public CategoryService(CategoryRepository category) {
        this.categoryRepo = category;
    }

    public List<Category> getAllCategories(String name) {
        List<Category> returnedCategories = new ArrayList<>();
        categoryRepo.findAll().forEach((cat) -> returnedCategories.add(cat));
        return returnedCategories;
    }

    public List<Category> getCategoriesByName(String categoryName) {
        List<Category> list = new ArrayList<>();
        categoryRepo.findAll().forEach((cat) -> list.add(cat));

        if (!categoryName.equals("")) {
            return list
                    .stream()
                    .filter(category -> category.getName().equals(categoryName))
                    .collect(Collectors.toList());

        }
        return list;
    }

    public Category newCategory(Category category) {
        return categoryRepo.save(category);
    }

    public Category getCategoryByID(String id) {

        return categoryRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Id not found"));
    }

    public Category updateCategory(Category category, String id) {
        getCategoryByID(id);
        category.setId(id);

        return this.categoryRepo.save(category);
    }

    public String listToString() {
        String returnString = "Categories:\n";
        List<Category> list = new ArrayList<>();
        categoryRepo.findAll().forEach((cat) -> list.add(cat));
        for (int i = 0; i < list.size(); i++) {
            returnString += "- Id: " + list.get(i).getId() + ", Name: " + list.get(i).getName() + ";\n";
        }

        return returnString;
    }


    public boolean deleteCategory(String id) {
        if (categoryRepo.existsById(id)) {
            categoryRepo.delete(getCategoryByID(id));
            return true;
        }
        throw new IllegalArgumentException("ID not found");
    }
}
