package com.webshop.dao;

import com.webshop.model.product.Category;

import java.util.List;

public interface CategoryDao
{
    void save(Category category);
    void remove(Category category);
    List<Category> getAll();
    Category getByName(String name);
}
