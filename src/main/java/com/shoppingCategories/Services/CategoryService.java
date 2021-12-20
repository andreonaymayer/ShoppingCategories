package com.shoppingCategories.Services;

import com.shoppingCategories.Repository.CategoryRepository;

public class CategoryService {
    private CategoryRepository categoryRepo;

    public CategoryService(CategoryRepository category) {
        this.categoryRepo = category;
    }

    public String listToString() {
        String returnString = "Categories:\n";
        for (int i = 0; i < categoryRepo.getCategoryList().size(); i++) {
            returnString += "- Id: " + categoryRepo.getCategoryList().get(i).getId() + ", Name: " + categoryRepo.getCategoryList().get(i).getName() + ";\n";
        }

        return returnString;
    }

}
