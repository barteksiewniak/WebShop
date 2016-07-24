package com.webshop.service.impl.mail;

import com.webshop.service.mail.MailService;
import com.webshop.model.mail.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service("mailService")
public class MailServiceImpl implements MailService
{
    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(Message message)
    {
        try
        {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(mimeMessage, false);
            helper.setTo(message.getRecipient());
            helper.setSubject(message.getSubject());
            helper.setText(message.getContent());
            mailSender.send(mimeMessage);
        }
        catch (MessagingException e)
        {
            throw new RuntimeException(e);
        }
    }
}
