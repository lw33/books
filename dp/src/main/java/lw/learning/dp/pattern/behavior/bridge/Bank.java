package lw.learning.dp.pattern.behavior.bridge;

/**
 * @Author lw
 * @Date 2018-12-16 22:57:17
 **/
public abstract class Bank {
    protected Account account;

    public Bank(Account account) {
        this.account = account;
    }

    abstract Account openAccount();

    public void setAccount(Account account) {
        this.account = account;
    }
}
