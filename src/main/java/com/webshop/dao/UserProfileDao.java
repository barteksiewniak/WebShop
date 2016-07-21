package com.webshop.dao;

import com.webshop.model.user.UserProfile;

public interface UserProfileDao
{
    UserProfile findByName(String name);
}
