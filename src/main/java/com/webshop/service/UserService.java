package com.webshop.service;

import com.webshop.model.User;

public interface UserService
{
    User findById(int id);
    User findBySso(String sso);
    void saveUser(User user);
}