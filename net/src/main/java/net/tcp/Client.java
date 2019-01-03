package net.tcp;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @Author lw
 * @Date 2019-01-02 18:24:02
 **/
public class Client {
    public static final int port = 8080;
    public static final int localPort = 8081;

    public static final int BUFFER = 64 * 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Socket socket = createSocket();
        initSocket(socket);
        socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), port));

        try {
            net.socket.Client.todo(socket);
        } catch (Exception e) {
            System.out.println("exception");
        }
        socket.close();
        System.out.println("client finished...");
    }

    public static Socket createSocket() throws Exception {
        //Socket socket = new Socket(Proxy.NO_PROXY);
        //Socket socket = new Socket(InetAddress.getLocalHost(), port);
        Socket socket = new Socket();
        //socket.bind(new InetSocketAddress(InetAddress.getLocalHost(), localPort));
        return socket;
    }

    public static void initSocket(Socket socket) throws Exception {

        //socket.setSoTimeout(3000);

        socket.setReuseAddress(true);

        socket.setTcpNoDelay(false);

        socket.setSoLinger(true, 200);

        socket.setOOBInline(false);

        socket.setSendBufferSize(BUFFER);
        socket.setReceiveBufferSize(BUFFER);

        // 性能参数  短连接 延迟 带宽的重要性
        socket.setPerformancePreferences(1, 1, 1);
    }
}
