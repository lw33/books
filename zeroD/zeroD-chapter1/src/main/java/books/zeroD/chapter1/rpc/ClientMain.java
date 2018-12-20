package books.zeroD.chapter1.rpc;

/**
 * @Author lw
 * @Date 2018-12-20 20:09:03
 **/
public class ClientMain {
    public static void main(String[] args) {
        HelloService helloService = CustomerProxy.consume(HelloService.class, "localhost", 8080);
        System.out.println(helloService.sayHello("hhhgfjhgh"));
    }
}
