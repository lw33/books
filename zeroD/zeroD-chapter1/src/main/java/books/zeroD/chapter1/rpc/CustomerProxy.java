package books.zeroD.chapter1.rpc;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @Author lw
 * @Date 2018-12-20 20:03:21
 **/
public class CustomerProxy {

    public static <T> T consume(Class<T> interfaceClass, String host, int port) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object res = null;
                Socket socket = new Socket(host, port);
                try {
                    OutputStream outputStream = socket.getOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                    objectOutputStream.writeUTF(method.getName());
                    objectOutputStream.writeObject(args);
                    InputStream inputStream = socket.getInputStream();
                    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                    res = objectInputStream.readObject();
                    if (res instanceof Exception) {
                        throw (Exception) res;
                    }
                } catch (Exception e) {

                } finally {
                    socket.close();
                }
                return res;
            }
        });
    }
}
