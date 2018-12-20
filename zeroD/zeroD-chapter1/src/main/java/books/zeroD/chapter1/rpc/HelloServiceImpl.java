package books.zeroD.chapter1.rpc;

/**
 * @Author lw
 * @Date 2018-12-20 19:51:30
 **/
public class HelloServiceImpl implements HelloService{
    @Override
    public String sayHello(String content) {
        return "hello, " + content;
    }
}
