package com.webshop.service.impl;

import com.webshop.dao.CategoryDao;
import com.webshop.model.Category;
import com.webshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public void saveCategory(Category category)
    {
        categoryDao.save(category);
    }
}
