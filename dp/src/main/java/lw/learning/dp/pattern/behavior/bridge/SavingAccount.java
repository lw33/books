package lw.learning.dp.pattern.behavior.bridge;

/**
 * @Author lw
 * @Date 2018-12-16 22:55:49
 **/
public class SavingAccount implements Account{
    @Override
    public Account openAccount() {
        System.out.println("SavingAccount.openAccount");
        return new SavingAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("SavingAccount.showAccountType");
    }
}
