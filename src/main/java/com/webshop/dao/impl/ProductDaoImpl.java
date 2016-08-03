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
    public List<Product> findByCategory(Category category)
    {
        CriteriaQuery<Product> query = createEntityCriteria();
        Root<Product> root = query.from(Product.class);

        query.select(root)
                .where(getCriteriaBuilder().equal(root.get("category"), category));

        TypedQuery<Product> tq = getEntityManager().createQuery(query);
        return tq.getResultList();
    }

    @Override
    public void removeProduct(int id)
    {
        delete(id);
    }
}
