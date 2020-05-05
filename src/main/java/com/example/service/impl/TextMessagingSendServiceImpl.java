package com.example.service.impl;

import com.example.service.TextMessagingSendService;
import com.example.util.EmailSendUtil;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/5 9:37
 */
@Service
public class TextMessagingSendServiceImpl implements TextMessagingSendService {
    @Override
    public boolean sendMail(String sendMail, String subject, String text) throws MessagingException {
        return EmailSendUtil.sendEmail(sendMail, subject, text);
    }
}
