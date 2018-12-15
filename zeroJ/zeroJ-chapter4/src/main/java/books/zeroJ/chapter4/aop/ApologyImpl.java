package books.zeroJ.chapter4.aop;

/**
 * @Author lw
 * @Date 2018-12-15 19:00:00
 **/
public class ApologyImpl implements Apology{
    @Override
    public void saySorry(String name) {
        System.out.println("ApologyImpl.saySorry " + name);
    }
}
