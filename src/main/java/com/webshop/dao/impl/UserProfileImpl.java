package com.webshop.dao.impl;

import com.webshop.dao.AbstractDao;
import com.webshop.dao.UserProfileDao;
import com.webshop.model.UserProfile;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("userProfileDao")
public class UserProfileImpl extends AbstractDao<Integer, UserProfile> implements UserProfileDao
{
    public UserProfile findByName(String name)
    {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("type", name));
        return (UserProfile) crit.uniqueResult();
    }
}
