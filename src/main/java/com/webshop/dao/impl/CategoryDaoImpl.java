package com.webshop.dao.impl;

import com.webshop.dao.AbstractDao;
import com.webshop.dao.CategoryDao;
import com.webshop.model.product.Category;
import org.springframework.stereotype.Repository;

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao<Integer, Category> implements CategoryDao
{
    @Override
    public void save(Category category)
    {
        persist(category);
    }
}
