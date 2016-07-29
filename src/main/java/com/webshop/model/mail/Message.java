package com.webshop.model.mail;

public class Message
{
    private final String content;

    private final String subject;

    private final String recipient;

    public Message(String content, String subject, String recipient)
    {
        this.content = content;
        this.subject = subject;
        this.recipient = recipient;
    }

    public String getContent()
    {
        return content;
    }

    public String getSubject()
    {
        return subject;
    }

    public String getRecipient()
    {
        return recipient;
    }
}
