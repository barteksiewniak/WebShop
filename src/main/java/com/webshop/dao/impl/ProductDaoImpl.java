package com.webshop.dao.impl;

import com.webshop.dao.AbstractDao;
import com.webshop.dao.ProductDao;
import com.webshop.model.Product;
import org.springframework.stereotype.Repository;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao
{
    @Override
    public Product findById(int id)
    {
        return getByKey(id);
    }

    @Override
    public void saveProduct(Product product)
    {
        persist(product);
    }
}
