package cn.name.util;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Nominal on 2018/1/18 0018.
 * 微博：@李明易DY
 */
public class MailUtils {

    /**
     * @param toUser 接收激活码邮箱
     * @param code   激活码
     */
    public static void sendMail(String toUser, String code) throws Exception {

        Properties props = new Properties();
        // 开启debug调试
        props.setProperty("mail.debug", "true");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "smtp.520oo.cn");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");

        // 设置环境信息
        Session session = Session.getInstance(props, new Authenticator() {
            // 在session中设置账户信息，Transport发送邮件时会使用
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("official@520oo.cn", "LMYlmy123");
            }
        });

        // 创建邮件对象
        Message msg = new MimeMessage(session);
        // 发件人
        msg.setFrom(new InternetAddress("official@520oo.cn"));
        // 多个收件人
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toUser));
        // 抄送人
       // msg.setRecipient(Message.RecipientType.CC, new InternetAddress("java_mail_001@163.com"));
        // 暗送人
        //msg.setRecipient(Message.RecipientType.BCC, new InternetAddress("java_mail_004@163.com"));

        // 主题
        msg.setSubject("账号激活邮件");
        // HTML内容
        msg.setContent("<div align='center'><h1>网站账号激活邮件</h1><h3>" +
                "<a href='http://127.0.0.1:8080/activate?code="+code+"'>点此激活http://127.0.0.1:8080/activate?code="+code+"</a></h3></div>", "text/html;charset=utf-8");

        // 连接邮件服务器、发送邮件、关闭连接，全干了
        Transport.send(msg);

    }
}
