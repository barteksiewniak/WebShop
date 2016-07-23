package com.webshop.configuration;

import com.webshop.model.user.User;
import com.webshop.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class StartupLoader {

    @Autowired
    UserService userService;

    @PostConstruct
    void checkDefault() {

      User user = userService.findBySso("admin");
        if (user == null) {
            user = new User();
            user.setFirstName("Default");
            user.setEmail("admin@webshop.com");
            user.setLastName("Default");
            user.setPassword("password");
            user.setSsoId("admin");
            userService.saveUser(user, "ADMIN");
        }
    }
}
