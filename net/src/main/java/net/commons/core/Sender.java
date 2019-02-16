package net.commons.core;

import java.io.Closeable;
import java.io.IOException;

/**
 * @Author lw
 * @Date 2019-02-10 14:58:24
 **/
public interface Sender extends Closeable {

    boolean sendAsync(IOArgs ioArgs, IOArgs.IOArgsEventListener listener) throws IOException;
}
