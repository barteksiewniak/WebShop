package com.webshop.dao.impl;

import com.webshop.dao.AbstractDao;
import com.webshop.dao.UserProfileDao;
import com.webshop.model.user.UserProfile;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository("userProfileDao")
public class UserProfileImpl extends AbstractDao<Integer, UserProfile> implements UserProfileDao
{
    public UserProfile findByName(String name)
    {
        CriteriaQuery<UserProfile> query = createEntityCriteria();
        Root<UserProfile> root = query.from(UserProfile.class);

        query.select(root)
                .where(getCriteriaBuilder().equal(root.get("type"), name));

        TypedQuery<UserProfile> tq = getEntityManager().createQuery(query);
        return tq.getSingleResult();
    }
}
