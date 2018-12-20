package books.zeroD.chapter1.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @Author lw
 * @Date 2018-12-20 16:52:48
 **/
public class ClientMain {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Runnable runnable = () -> {
            try {

                HelloService helloService = (HelloService) Naming.lookup("rmi://localhost:8081/helloService");
                System.out.println(Thread.currentThread().getName() + " RMI 调用结果为 " + helloService.sayHello("java"));
            } catch (Exception e) {

            }
        };

        int n = 1000;
        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }

    }
}
