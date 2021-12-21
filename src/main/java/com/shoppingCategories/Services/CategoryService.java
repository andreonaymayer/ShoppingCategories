package com.shoppingCategories.Services;

import com.shoppingCategories.Entities.Category;
import com.shoppingCategories.Repository.CategoryRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired

    private CategoryRepository categoryRepo;

    public CategoryService(CategoryRepository category) {
        //category = new CategoryRepository();
        this.categoryRepo = category;
    }

    public String listToString() {
        String returnString = "Categories:\n";
        for (int i = 0; i < categoryRepo.getCategoryList().size(); i++) {
            returnString += "- Id: " + categoryRepo.getCategoryList().get(i).getId() + ", Name: " + categoryRepo.getCategoryList().get(i).getName() + ";\n";
        }

        return returnString;
    }

    public List<Category> getCategoriesOrByName(String categoryName) {
        List<Category> list = categoryRepo.getCategoryList();

        if (!categoryName.equals("")) {
            return list
                    .stream()
                    .filter(category -> category.getName().equals(categoryName))
                    .collect(Collectors.toList());

        }
        return list;
    }

    public Category newCategory(Category category) {
        return categoryRepo.addCategory(category);
    }


    public Category getCategoryByID(String id) {
        List<Category> list = categoryRepo.getCategoryList();

        for (int i=0; i< list.size(); i++){
            if (list.get(i).getId().equals(id)){
                return list.get(i);
            }
        }
        return null;
    }
}
