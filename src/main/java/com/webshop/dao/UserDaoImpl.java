package com.webshop.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.webshop.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao
{
    public User findById(int id)
    {
        return getByKey(id);
    }

    public User findBySSO(String sso)
    {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        return (User) crit.uniqueResult();
    }

    public void saveUser(User user)
    {
        persist(user);
    }
}
