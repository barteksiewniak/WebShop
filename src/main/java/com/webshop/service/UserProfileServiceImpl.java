package com.webshop.service;

import com.webshop.dao.UserProfileDao;
import com.webshop.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService
{
    @Autowired
    private UserProfileDao userProfileDao;

    public UserProfile findByName(String name)
    {
        return userProfileDao.findByName(name);
    }
}
