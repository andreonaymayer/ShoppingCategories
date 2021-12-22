package com.shoppingCategories.Repository;

import com.shoppingCategories.Entities.Category;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {
    private List<Category> categoryList = new ArrayList<>();


    public CategoryRepository() {

        addCategory(new Category("", "Food"));
        addCategory(new Category("", "Drinks"));
        addCategory(new Category("", "Services"));
        addCategory(new Category("", "Vegan"));
        addCategory(new Category("", "Sports"));
    }

    public Category addCategory(Category newCategory) {
        if (!nameAlreadyExists(newCategory.getName())) {
            categoryList.add(newCategory);
            return newCategory;
        }
        return null;
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

    public int getIndexOfItem(String categoryNameOrID) {
        for (int i = 0; i < categoryList.size(); i++) {
            if (categoryList.get(i).getName().equals(categoryNameOrID)) {
                return i;
            } else if (categoryList.get(i).getId().equals(categoryNameOrID)) {
                return i;
            }
        }
        return -1;
    }

    public boolean editCategory(Category category, String categoryNameOrID) {
        int index = getIndexOfItem(categoryNameOrID);
        if (index != -1) {
            categoryList.get(index).setName(category.getName());
            return true;
        }
        return false;
    }

    public boolean deleteCategory(String categoryNameOrID) {
        int index = getIndexOfItem(categoryNameOrID);
        if (index != -1) {
            categoryList.remove(index);
            return true;
        }
        return false;
    }

}