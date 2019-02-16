package net.commons.core;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 对 channel 读写
 * @Author lw
 * @Date 2019-02-10 14:53:26
 **/
public class IOArgs {

    private byte[] byteBuffer = new byte[256];
    private ByteBuffer buffer = ByteBuffer.wrap(byteBuffer);

    public int read(SocketChannel channel) throws IOException {
        buffer.clear();
        return channel.read(buffer);
    }

    public int write(SocketChannel channel) throws IOException {
        return channel.write(buffer);
    }

    public String bufferString() {
        return new String(buffer.array(), 0, buffer.position());
    }

    /**
     * 监听 IOArgs
     */
    public interface IOArgsEventListener {

        void onStarted(IOArgs args);

        void onCompleted(IOArgs args);
    }
}
