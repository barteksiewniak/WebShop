package com.webshop.dao.impl;

import com.webshop.dao.AbstractDao;
import com.webshop.dao.UserProfileDao;
import com.webshop.model.user.UserProfile;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

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
        List<UserProfile> list = tq.getResultList();
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<UserProfile> getAll()
    {
        return findAll();
    }

    @Override
    public void save(UserProfile s)
    {
        persist(s);
    }
}
