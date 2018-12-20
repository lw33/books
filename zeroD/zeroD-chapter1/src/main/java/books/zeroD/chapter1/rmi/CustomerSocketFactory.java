package books.zeroD.chapter1.rmi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMISocketFactory;

/**
 * @Author lw
 * @Date 2018-12-20 17:03:33
 **/
public class CustomerSocketFactory extends RMISocketFactory {
    @Override
    public Socket createSocket(String host, int port) throws IOException {

        return new Socket(host, port);
    }

    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        if (port == 0) {
            port = 8501;
        }
        System.out.println("rmi notify port: " + port);
        return new ServerSocket(port);
    }

}
