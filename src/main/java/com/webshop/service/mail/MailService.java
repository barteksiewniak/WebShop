package com.webshop.service.mail;

import com.webshop.model.mail.Message;

public interface MailService
{
    void sendMail(Message message);
}
