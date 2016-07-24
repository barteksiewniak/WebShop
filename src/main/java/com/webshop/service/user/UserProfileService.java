package com.webshop.service.user;

import com.webshop.model.user.UserProfile;

import java.util.List;

public interface UserProfileService
{
    UserProfile findByName(String name);

    List<UserProfile> list();

    void addUserProfile(UserProfile s);
}
