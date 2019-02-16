package net.commons.core;

import net.commons.impl.SocketChannelAdapter;
import net.commons.util.CloseUtils;

import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.util.UUID;

/**
 * 对一个连接的抽象
 * 封装了 channel
 * @Author lw
 * @Date 2019-02-10 14:51:32
 **/
public class Connector implements Closeable, SocketChannelAdapter.OnChannelStatusChangeListener {

    private UUID key = UUID.randomUUID();
    private SocketChannel channel;
    // 发送者
    private Sender sender;
    // 接受者
    private Receiver receiver;

    public void setup(SocketChannel socketChannel) throws IOException {
        channel = socketChannel;
        IOContext ioContext = IOContext.get();
        SocketChannelAdapter socketChannelAdapter = new SocketChannelAdapter(channel, ioContext.getIoProvider(), this);

        this.sender = socketChannelAdapter;
        this.receiver = socketChannelAdapter;

        readNextMessage();
    }

    private void readNextMessage() {
        if (receiver != null) {
            try {
                receiver.receiveAsync(echoReceiveListener);
            } catch (IOException e) {
                System.out.println("receive data exception...");
            }
        }
    }

    @Override
    public void close() throws IOException {
        CloseUtils.close(channel);
    }

    private IOArgs.IOArgsEventListener echoReceiveListener = new IOArgs.IOArgsEventListener() {

        @Override
        public void onStarted(IOArgs args) {

        }

        @Override
        public void onCompleted(IOArgs args) {
            onReceiveNewMessage(args.bufferString());
            readNextMessage();
        }
    };

    public void onReceiveNewMessage(String str) {
        System.out.println(key.toString() + ": " + str);
    }
    @Override
    public void onChannelClosed(SocketChannel channel) {

    }
}
