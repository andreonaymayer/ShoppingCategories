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

    public List<Category> getAllCategories(String name){
        List<Category> returnedCategories = new ArrayList<>();
        categoryRepo.findAll().forEach((cat)-> returnedCategories.add(cat));
        System.out.println("________+++++++++++++++(((((((((((( PROBLEMA )))))))))+++++++++++___________");
        return returnedCategories;
    }

//    public String listToString() {
//        String returnString = "Categories:\n";
//        for (int i = 0; i < categoryRepo.getCategoryList().size(); i++) {
//            returnString += "- Id: " + categoryRepo.getCategoryList().get(i).getId() + ", Name: " + categoryRepo.getCategoryList().get(i).getName() + ";\n";
//        }
//
//        return returnString;
//    }
//
//    public List<Category> getCategoriesOrByName(String categoryName) {
//        List<Category> list = categoryRepo.getCategoryList();
//
//        if (!categoryName.equals("")) {
//            return list
//                    .stream()
//                    .filter(category -> category.getName().equals(categoryName))
//                    .collect(Collectors.toList());
//
//        }
//        return list;
//    }
//
//    public Category newCategory(Category category) {
//        return categoryRepo.addCategory(category);
//    }
//
//
//    public Category getCategoryByID(String id) {
//        List<Category> list = categoryRepo.getCategoryList();
//
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getId().equals(id)) {
//                return list.get(i);
//            }
//        }
//        return null;
//    }
//
//    public Category updateCategory(Category category, String id) {
//        if (categoryRepo.editCategory(category, id)) {
//            return category;
//        }
//        throw new IllegalArgumentException("ID not found");
//    }
//
//    public boolean deleteCategory(String id) {
//        if (categoryRepo.deleteCategory(id)) {
//            return true;
//        }
//        throw new IllegalArgumentException("ID not found");
//    }
}
