package com.webshop.dao.impl;

import com.webshop.dao.AbstractDao;
import com.webshop.dao.CategoryDao;
import com.webshop.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDao<Integer, Category> implements CategoryDao
{
    @Autowired
    CategoryDao categoryDao;

    @Override
    public void save(Category category)
    {
        categoryDao.save(category);
    }
}
