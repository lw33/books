package net.commons.core;

import java.io.Closeable;
import java.nio.channels.SocketChannel;

/**
 * 提供对相应 channel 的注册、解除注册与回调
 * @Author lw
 * @Date 2019-02-10 14:58:06
 **/
public interface IOProvider extends Closeable {


    /**
     * 对 channel 注册输入
     *
     * @param channel  对应 channel
     * @param callback 注册后的回调
     * @return 成功与否
     */
    boolean registerInput(SocketChannel channel, HandleInputCallback callback);

    /**
     * 对 channel 注册输出
     *
     * @param channel  对应 channel
     * @param callback 注册后的回调
     * @return 成功与否
     */
    boolean registerOutput(SocketChannel channel, HandleOutputCallback callback);

    /**
     * 取消对对应的 channel 注册的 输入
     * @param channel channel
     */
    void unRegisterInput(SocketChannel channel);

    /**
     * 取消对对应的 channel 注册的 输出
     * @param channel channel
     */
    void unRegisterOutput(SocketChannel channel);

    /**
     * 处理输入
     */
    abstract class HandleInputCallback implements Runnable {

        @Override
        public void run() {
            canProviderInput();
        }

        protected abstract void canProviderInput();
    }

    /**
     * 处理输出
     */
    abstract class HandleOutputCallback implements Runnable {

        private Object attach;

        public HandleOutputCallback() {

        }

        @Override
        public void run() {
            canProviderOutput(attach);
        }

        public final void setAttach(Object attach) {
            this.attach = attach;
        }

        protected abstract void canProviderOutput(Object attach);
    }
}
