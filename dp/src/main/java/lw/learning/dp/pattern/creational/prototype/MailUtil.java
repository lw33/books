package lw.learning.dp.pattern.creational.prototype;

import java.text.MessageFormat;

/**
 * @Author lw
 * @Date 2018-12-15 21:54:25
 **/
public class MailUtil {

    public static void sendMail(Mail mail) {
        String content = "send to {0}, mail address {1}, content: {2}...success...";
        System.out.println(MessageFormat.format(content, mail.getName(), mail.getEmailAddress(), mail.getContent()));
    }

    public static void saveOriginMailRecord(Mail originMail) {
        System.out.println("save template: " + originMail.getContent());
    }
}
