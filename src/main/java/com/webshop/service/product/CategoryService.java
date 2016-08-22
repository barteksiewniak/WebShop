package com.webshop.service.product;

import com.webshop.model.product.Category;

import java.util.List;

public interface CategoryService
{
    void saveCategory(Category category);
    void removeCategory(Category category);
    Category findByName(String name);
    List<Category> listOfCategories();
    Category getByName(String category);

}
