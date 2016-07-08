package com.webshop.dao;

import com.webshop.model.User;

public interface UserDao
{
    User findById(int id);
    User findBySSO(String sso);
    void saveUser(User user);
}

