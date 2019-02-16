package net.commons.core;

import java.io.IOException;

/**
 * @Author lw
 * @Date 2019-02-10 14:58:17
 **/
public interface Receiver {
    /**
     * 接收
     * @param listener
     * @return
     * @throws IOException
     */
    boolean receiveAsync(IOArgs.IOArgsEventListener listener) throws IOException;
}
