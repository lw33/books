package lw.learning.dp.pattern.behavior.bridge;

/**
 * @Author lw
 * @Date 2018-12-16 23:00:37
 **/
public class ABCBank extends Bank{

    public ABCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("ABCBank.openAccount");
        return account;
    }
}
