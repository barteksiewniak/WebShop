package com.webshop.controller;

import com.webshop.model.user.User;
import com.webshop.service.user.UserService;
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
        //Validation code start
        boolean error = false;

        if (user.getFirstName().isEmpty())
        {
            result.rejectValue("firstName", "error.firstName");
            error = true;
        }

        if (user.getLastName().isEmpty())
        {
            result.rejectValue("lastName", "error.lastName");
            error = true;
        }

        if (user.getEmail().isEmpty())
        {
            result.rejectValue("email", "error.email");
            error = true;
        }

        if (user.getPassword().isEmpty())
        {
            result.rejectValue("password", "error.password");
            error = true;
        }

        if (user.getSsoId().isEmpty())
        {
            result.rejectValue("ssoId", "error.ssoId");
            error = true;
        } else if (userService.findBySso(user.getSsoId()) != null)
        {
            result.rejectValue("ssoId", "error.exist");
            error = true;
        }

        if (error)
        {
            return "addUser";
        }

        userService.saveUser(user, "USER");

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
