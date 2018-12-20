package books.zeroD.chapter1.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Author lw
 * @Date 2018-12-20 16:49:45
 **/
public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {


    private static final long serialVersionUID = 8780674566996285174L;

    protected HelloServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String someOne) throws RemoteException {
        return "Hello, " + someOne;
    }
}
