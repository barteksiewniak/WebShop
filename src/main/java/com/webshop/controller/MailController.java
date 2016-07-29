package com.webshop.controller;

import com.webshop.service.mail.MailService;
import com.webshop.model.mail.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MailController
{
    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String sendMail()
    {
        mailService.sendMail(new Message("zawartosc", "tematdwa", "barteksiewniak@gmail.com"));
        return "mailSent";
    }
}
