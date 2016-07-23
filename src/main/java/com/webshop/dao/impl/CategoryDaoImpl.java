package com.webshop.dao.impl;

import com.webshop.dao.AbstractDao;
import com.webshop.dao.CategoryDao;
import com.webshop.model.product.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao<Integer, Category> implements CategoryDao
{
    @Override
    public void save(Category category)
    {
        persist(category);
    }

    @Override
    public List<Category> getAll() {
        return findAll();
    }
}
