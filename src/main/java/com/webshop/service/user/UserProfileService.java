package com.webshop.service.user;

import com.webshop.model.user.UserProfile;

public interface UserProfileService
{
    UserProfile findByName(String name);
}
