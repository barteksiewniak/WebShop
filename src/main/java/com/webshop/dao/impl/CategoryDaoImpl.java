package com.webshop.dao.impl;

import com.webshop.dao.AbstractDao;
import com.webshop.dao.CategoryDao;
import com.webshop.model.product.Category;
import com.webshop.model.user.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    public List<Category> getAll()
    {
        return findAll();
    }

    @Override
    public Category getByName(String name)
    {
        try
        {
            CriteriaQuery<Category> query = createEntityCriteria();
            Root<Category> root = query.from(Category.class);

            query.select(root)
                    .where(getCriteriaBuilder().equal(root.get("categoryName"), name));

            TypedQuery<Category> tq = getEntityManager().createQuery(query);
            return tq.getSingleResult();
        } catch (NoResultException nre)
        {
            return null;
        }
    }
}
