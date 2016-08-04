package com.webshop.service.impl.product;

import com.webshop.dao.CategoryDao;
import com.webshop.model.product.Category;
import com.webshop.service.product.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category findByName(String name)
    {
        return categoryDao.getByName(name);
    }

    @Override
    public void saveCategory(Category category)
    {
        categoryDao.save(category);
    }

    @Override
    public List<Category> listOfCategories()
    {
        return categoryDao.getAll();
    }

    @Override
    public Category getByName(String category)
    {
        return categoryDao.getByName(category);
    }
}
