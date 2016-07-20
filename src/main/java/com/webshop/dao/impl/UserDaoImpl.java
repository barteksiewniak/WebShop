package com.webshop.dao.impl;

import com.webshop.dao.AbstractDao;
import com.webshop.dao.UserDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.webshop.model.User;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao
{
    public User findById(int id)
    {
        return getByKey(id);
    }

    public User findBySSO(String sso)
    {
        CriteriaQuery<User> query = createEntityCriteria();
        Root<User> root = query.from(User.class);

        query.select(root)
                .where(getCriteriaBuilder().equal(root.get("ssoId"), sso));

        TypedQuery<User> tq = getEntityManager().createQuery(query);
        return tq.getSingleResult();
    }

    public void saveUser(User user)
    {
        persist(user);
    }
}
