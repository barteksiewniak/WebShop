package com.webshop.dao.impl;

import com.webshop.dao.AbstractDao;
import com.webshop.dao.ProductDao;
import com.webshop.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
