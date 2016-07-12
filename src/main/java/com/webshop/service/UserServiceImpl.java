package com.webshop.service;

import com.webshop.model.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webshop.dao.UserDao;
import com.webshop.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDao dao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findById(int id)
    {
        return dao.findById(id);
    }

    public User findBySso(String sso)
    {
        return dao.findBySSO(sso);
    }

    public void saveUser(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setState(State.ACTIVE.getState());
        dao.saveUser(user);
    }
}
