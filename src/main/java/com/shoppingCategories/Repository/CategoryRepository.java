package com.shoppingCategories.Repository;

import com.shoppingCategories.Entities.Category;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public class CategoryRepository {
    private List<Category> categoryList = new ArrayList<>();


    public CategoryRepository() {

        addCategory(new Category("","Food"));
        addCategory(new Category("","Drinks"));
        addCategory(new Category("","Services"));
        addCategory(new Category("","Vegan"));
        addCategory(new Category("","Sports"));
    }

    public Category addCategory(Category newCategory) {
        if (!nameAlreadyExists(newCategory.getName())) {
            categoryList.add(newCategory);
            return newCategory;
        }
        return null;
    }

    public boolean deleteCategory(String categoryName) {
        int index = getIndexOfItem(categoryName);
        if (index == -1) {
            return false;
        }
        categoryList.remove(index);
        return true;

    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public boolean nameAlreadyExists(String name) {
        for (int i = 0; i < categoryList.size(); i++) {
            if (name.equals(categoryList.get(i).getName())) {
                return true;
            }
        }

        return false;
    }

    public int getIndexOfItem(String categoryName) {
        for (int i = 0; i < categoryList.size(); i++) {
            if (categoryList.get(i).getName().equals(categoryName)) {
                return i;
            }
        }
        return -1;
    }

    public boolean editCategory(String categoryName, String categoryNewName) {
        int index = getIndexOfItem(categoryName);
        if (index != -1) {
            categoryList.get(index).setName(categoryNewName);
            return true;
        }
        return false;
    }


}