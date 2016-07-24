package com.webshop.service.user;

import com.webshop.model.user.User;

public interface UserService
{
    User findById(int id);

    User findBySso(String sso);

    void saveUser(User user, String userType);
}