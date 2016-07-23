package com.webshop.service.product;

import com.webshop.model.product.Category;

import java.util.List;

public interface CategoryService
{
    void saveCategory(Category category);

    List<Category> list();
}
