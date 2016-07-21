package com.webshop.dao.impl;

import com.webshop.dao.AbstractDao;
import com.webshop.dao.ProductDao;
import com.webshop.model.product.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao
{
    @Override
    public Product findById(int id)
    {
        return getByKey(id);
    }

    @Override
    public void addProduct(Product product)
    {
        persist(product);
    }

    @Override
    public void updateProduct(Product product)
    {
        update(product);
    }

    @Override
    public List<Product> listOfProducts()
    {
        return findAll();
    }

    @Override
    public void removeProduct(int id)
    {
        removeProduct(id);
    }
}
