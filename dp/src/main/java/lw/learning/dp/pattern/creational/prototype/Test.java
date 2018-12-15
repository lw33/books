package lw.learning.dp.pattern.creational.prototype;

/**
 * @Author lw
 * @Date 2018-12-15 21:57:32
 **/
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Mail mail = new Mail();
        mail.setContent("initial");
        for (int i = 0; i < 10; i++) {
            Mail tmpMail = (Mail) mail.clone();
            tmpMail.setName("java" + i);
            tmpMail.setEmailAddress("java" + i + "@java.com");
            tmpMail.setContent("are you ok?");
            MailUtil.sendMail(tmpMail);
        }
        MailUtil.saveOriginMailRecord(mail);
    }
}
