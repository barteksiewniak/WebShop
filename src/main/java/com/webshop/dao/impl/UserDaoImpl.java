package com.webshop.dao.impl;

import com.webshop.dao.AbstractDao;
import com.webshop.dao.UserDao;
import org.springframework.stereotype.Repository;

import com.webshop.model.user.User;

import javax.persistence.NoResultException;
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
        try
        {
            CriteriaQuery<User> query = createEntityCriteria();
            Root<User> root = query.from(User.class);

            query.select(root)
                    .where(getCriteriaBuilder().equal(root.get("ssoId"), sso));

            TypedQuery<User> tq = getEntityManager().createQuery(query);
            return tq.getSingleResult();
        }

        // read about better solution than try/catch
        // http://stackoverflow.com/questions/8138458/javax-persistence-noresultexception-no-entity-found-for-query
        catch (NoResultException nre)
        {
            return null;
        }
    }

    public void saveUser(User user)
    {
        persist(user);
    }
}
