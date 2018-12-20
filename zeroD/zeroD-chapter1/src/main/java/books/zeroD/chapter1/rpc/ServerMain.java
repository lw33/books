package books.zeroD.chapter1.rpc;

/**
 * @Author lw
 * @Date 2018-12-20 20:08:23
 **/
public class ServerMain {
    public static void main(String[] args) throws Exception {
        ProviderReflect.provider(new HelloServiceImpl(), 8080);
    }
}
