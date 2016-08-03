package com.webshop.dao.impl;

import com.webshop.dao.AbstractDao;
import com.webshop.dao.ProductDao;
import com.webshop.model.product.Category;
import com.webshop.model.product.Product;
import com.webshop.model.user.User;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
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
    public voi findByCategory(Category category)
    {
        CriteriaQuery<Product> query = getCriteriaBuilder().createQuery(Product.class);
        Root<Product> product = query.from(Product.class);
        Join<Product, Category> categories = product.join("categories");
        query.where(getCriteriaBuilder().equal(categories.get("categoryName"), "CPU"));
    }

    @Override
    public void removeProduct(int id)
    {
        delete(id);
    }
}
