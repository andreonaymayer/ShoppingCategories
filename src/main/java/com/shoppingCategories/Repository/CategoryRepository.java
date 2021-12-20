package com.shoppingCategories.Repository;

import com.shoppingCategories.Entities.Category;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    private List<Category> categoryList = new ArrayList<>();


    public boolean addCategory(String categoryName) {

        if (!nameAlreadyExists(categoryName)) {
            categoryList.add(new Category(categoryName));
            return true;
        }
        return false;
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