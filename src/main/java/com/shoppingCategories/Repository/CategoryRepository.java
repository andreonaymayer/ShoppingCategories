package com.shoppingCategories.Repository;

import com.shoppingCategories.Entities.Category;
import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository<Category, String> {

}