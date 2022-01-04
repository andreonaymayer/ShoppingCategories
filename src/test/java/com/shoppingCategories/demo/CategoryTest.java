//package com.shoppingCategories.demo;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.is;
//import com.shoppingCategories.Entities.Category;
//import com.shoppingCategories.Repository.CategoryRepository;
//import com.shoppingCategories.Services.CategoryService;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//public class CategoryTest {
//
//    @Test
//    @DisplayName("Add 2 categories to list, and test if works")
//    public void insertCategoryInList() {
//        CategoryRepository categoryRepo = new CategoryRepository();
//        categoryRepo.addCategory(new Category("", "Category 1"));
//        categoryRepo.addCategory(new Category("", "Category 2"));
//        int actual = categoryRepo.getCategoryList().size();
//
//        assertThat("The number of categories is correct", actual, is(7));
//    }
//
//    @Test
//    @DisplayName("Verify if already have other category with same name")
//    public void verifyIfExistsCategoryName() {
//        CategoryRepository categoryRepo = new CategoryRepository();
//        categoryRepo.addCategory(new Category("", "Category 1"));
//
//        boolean actual = categoryRepo.nameAlreadyExists("Category 1");
//
//        assertThat("nameAlreadyExists return the index item, or -1 if this item don't exists", actual, is(true));
//    }
//
//    @Test
//    @DisplayName("List all categories of repository")
//    public void testCategoryList() {
//        CategoryRepository categoryRepo = new CategoryRepository();
//        CategoryService categoryService = new CategoryService(categoryRepo);
//
//        System.out.println(categoryService.listToString());
//    }
//
//    @Test
//    @DisplayName("Delete Category by name")
//    public void testCategoryDelete() {
//        CategoryRepository categoryRepo = new CategoryRepository();
//        categoryRepo.deleteCategory("Food");
//        CategoryService categoryService = new CategoryService(categoryRepo);
//        System.out.println("RESULT:\n" + categoryService.listToString());
//
//        int actual = categoryRepo.getCategoryList().size();
//        assertThat("The number of categories is correct", actual, is(4));
//    }
//
//    @Test
//    @DisplayName("Edit Category")
//    public void editCategory() {
//        CategoryRepository categoryRepo = new CategoryRepository();
//        Category computers = new Category("", "Personal computers");
//        categoryRepo.editCategory(computers, "Food");
//
//        String expected = categoryRepo.getCategoryList().get(0).getName();
//
//        assertThat("The name is not the same", expected, is("Personal computers"));
//
//    }
//
//}
