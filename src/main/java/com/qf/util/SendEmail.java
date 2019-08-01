package com.qf.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

  public static boolean Send(String to,String code) {
        String from = "QCutePet@163.com";
        String host ="smtp.163.com";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties,new Authenticator(){
                    public PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("QCutePet@163.com", "qpet123"); //发件人邮件用户名、密码
                       }
        });
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("【Q萌宠物】注册邮箱验证");
            message.setText("亲爱的Q萌宠物用户：您好！本次注册的验证码为"+code);
            Transport.send(message);
            return true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        }
    }
}