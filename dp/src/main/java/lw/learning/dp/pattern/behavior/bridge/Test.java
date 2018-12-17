package lw.learning.dp.pattern.behavior.bridge;

/**
 * @Author lw
 * @Date 2018-12-16 22:56:30
 **/
public class Test {

    public static void main(String[] args) {
        Account account = new SavingAccount();
        Account account1 = new DepositeAccount();
        account.openAccount();
    }
}
