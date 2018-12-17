package lw.learning.dp.pattern.behavior.bridge;

/**
 * @Author lw
 * @Date 2018-12-16 23:01:18
 **/
public class ICBCBank extends Bank{
    public ICBCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("ICBCBank.openAccount");
        return account;
    }
}
