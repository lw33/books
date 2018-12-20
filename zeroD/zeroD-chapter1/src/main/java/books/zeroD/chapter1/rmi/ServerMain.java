package books.zeroD.chapter1.rmi;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMISocketFactory;

/**
 * @Author lw
 * @Date 2018-12-20 16:51:22
 **/
public class ServerMain {

    public static void main(String[] args) throws IOException, AlreadyBoundException {

        HelloService helloService = new HelloServiceImpl();
        LocateRegistry.createRegistry(8081);
        RMISocketFactory.setSocketFactory(new CustomerSocketFactory());
        Naming.bind("rmi://localhost:8081/helloService", helloService);
        System.out.println("ServerMain provide RPC service now");
    }
}
