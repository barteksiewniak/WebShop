package com.webshop.service;

import com.webshop.model.UserProfile;

public interface UserProfileService
{
    UserProfile findByName(String name);
}
