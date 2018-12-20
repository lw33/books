package books.zeroD.chapter1.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Author lw
 * @Date 2018-12-20 16:47:03
 **/
public interface HelloService extends Remote {

    String sayHello(String someOne) throws RemoteException;
}
