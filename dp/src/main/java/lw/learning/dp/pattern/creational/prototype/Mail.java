package lw.learning.dp.pattern.creational.prototype;

/**
 * @Author lw
 * @Date 2018-12-15 21:50:16
 **/
public class Mail implements Cloneable{

    private String name;
    private String emailAddress;
    private String content;
    
    public Mail(){
        System.out.println("Mail class constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
