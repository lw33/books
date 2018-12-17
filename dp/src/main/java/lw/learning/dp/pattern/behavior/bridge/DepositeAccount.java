package lw.learning.dp.pattern.behavior.bridge;

/**
 * @Author lw
 * @Date 2018-12-16 22:55:36
 **/
public class DepositeAccount implements Account{
    @Override
    public Account openAccount() {
        System.out.println("DepositeAccount.openAccount");
        return new DepositeAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("DepositeAccount.showAccountType");
    }
}
