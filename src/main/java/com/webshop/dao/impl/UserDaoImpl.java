package com.webshop.dao.impl;

import com.webshop.dao.AbstractDao;
import com.webshop.dao.UserDao;
import org.springframework.stereotype.Repository;

import com.webshop.model.user.User;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

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
        List<User> list = tq.getResultList();
        return list.isEmpty() ? null : list.get(0);
    }

    public void saveUser(User user)
    {
        persist(user);
    }
}
