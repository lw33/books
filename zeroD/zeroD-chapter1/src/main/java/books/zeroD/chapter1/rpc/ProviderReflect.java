package books.zeroD.chapter1.rpc;

import org.apache.commons.lang3.reflect.MethodUtils;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author lw
 * @Date 2018-12-20 19:54:31
 **/
public class ProviderReflect {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    public static void provider(Object service, int port) throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = null;
            ObjectOutputStream objectOutputStream = null;
            try {
                socket = serverSocket.accept();
                System.out.println(socket.getInetAddress());
                System.out.println(socket.getRemoteSocketAddress());
                System.out.println(socket.getPort());
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                String methodName = objectInputStream.readUTF();
                Object[] args = (Object[]) objectInputStream.readObject();
                Object o = MethodUtils.invokeMethod(service, methodName, args);
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(o);
                //int i = 1 / 0;
            } catch (Exception e) {
                objectOutputStream.writeObject(e);
            } finally {
                try {
                    socket.close();
                } catch (Exception e) {

                }
            }
        }
    }
}
