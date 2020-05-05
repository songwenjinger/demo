package com.example.util;

/**
 * @ author: SongWenjing
 * @ Date 2020/5/5 9:11
 */

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class EmailSendUtil {
    public static Boolean sendEmail(String receiveMailAddress, String subject, String text) throws AddressException, MessagingException {
        String sendMailAddress = "3189064417@qq.com";
        String authorizationCode = "ajngigknmvosdcjg";
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp"); // 连接协议
        properties.put("mail.smtp.host", "smtp.qq.com"); // 主机名
        properties.put("mail.smtp.port", 465);  // 端口号
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");  // 设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.debug", "true"); // 设置是否显示debug信息 true 会在控制台显示相关信息
        // 得到回话对象
        try {
            Session session = Session.getInstance(properties);
            // 获取邮件对象
            Message message = new MimeMessage(session);
            // 设置发件人邮箱地址
            message.setFrom(new InternetAddress(sendMailAddress));
            // 设置收件人地址
            message.setRecipients(RecipientType.TO, new InternetAddress[]{new InternetAddress(receiveMailAddress)});
            // 设置邮件标题
            message.setSubject(subject);
            // 设置邮件内容
            message.setText(text);
            // 得到邮差对象
            Transport transport = session.getTransport();
            // 连接自己的邮箱账户
            transport.connect(sendMailAddress, authorizationCode);// 密码为刚才得到的授权码
            // 发送邮件
            transport.sendMessage(message, message.getAllRecipients());
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) throws AddressException, MessagingException {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp"); // 连接协议
        properties.put("mail.smtp.host", "smtp.qq.com"); // 主机名
        properties.put("mail.smtp.port", 465);  // 端口号
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");  // 设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.debug", "true"); // 设置是否显示debug信息 true 会在控制台显示相关信息
        // 得到回话对象
        Session session = Session.getInstance(properties);
        // 获取邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人邮箱地址
        message.setFrom(new InternetAddress("3189064417@qq.com"));
        // 设置收件人地址
        message.setRecipients(RecipientType.TO, new InternetAddress[]{new InternetAddress("13201656250@163.com")});
        // 设置邮件标题
        message.setSubject("由JavaMail发出的测试邮件");
        // 设置邮件内容
        message.setText("内容为： 这是第一封java发送来的邮件");
        // 得到邮差对象
        Transport transport = session.getTransport();
        // 连接自己的邮箱账户
        transport.connect("3189064417@qq.com", "ajngigknmvosdcjg");// 密码为刚才得到的授权码
        // 发送邮件
        transport.sendMessage(message, message.getAllRecipients());
    }
}