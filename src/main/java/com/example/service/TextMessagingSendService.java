package com.example.service;

import javax.mail.MessagingException;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/5 9:36
 */
public interface TextMessagingSendService {
    public boolean sendMail(String sendMail, String subject, String text) throws MessagingException;
}
