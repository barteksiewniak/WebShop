package com.webshop.dao;

import com.webshop.model.UserProfile;

public interface UserProfileDao
{
    UserProfile findByName(String name);
}
