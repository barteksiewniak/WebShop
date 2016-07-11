package com.webshop.controller;

import com.webshop.model.State;
import com.webshop.model.User;
import com.webshop.model.UserProfile;
import com.webshop.model.UserProfileType;
import com.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/addNew")
@SessionAttributes("user")
public class UserController
{
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("user") User user,
                             BindingResult result, SessionStatus status)
    {
        //Store the employee information in database
        user.setState(State.ACTIVE.getState());
        userService.saveUser(user);

        //Mark Session Complete
        status.setComplete();
        return "redirect:addNew/success";
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success(Model model)
    {
        return "userAdded";
    }
}
