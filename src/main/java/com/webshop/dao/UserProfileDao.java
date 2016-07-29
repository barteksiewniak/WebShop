package com.webshop.dao;

import com.webshop.model.user.UserProfile;

import java.util.List;

public interface UserProfileDao
{
    UserProfile findByName(String name);

    List<UserProfile> getAll();

    void save(UserProfile s);
}
