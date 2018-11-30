package lw.books.htw.c1;

import lw.books.htw.utils.Constant;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author lw
 * @Date 2018-11-29 19:18:07
 **/
public class Response {

    private static final int BUFFER_SIZE = 1024;
    Request request;
    OutputStream output;



    public Response(OutputStream output) {
        this.output = output;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() {

        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fin = null;
        try {
            if (request.getUri() == null) {
                notFount();
                return;
            } else if (request.getUri().equals(Constant.SHUTDOWN_COMMAND)) {
                write(Constant.SHUTDOWNMSG);
                return;
            }

            File file = new File(Constant.WEB_ROOT, request.getUri());
            if (file.exists()) {
                output.write(Constant.OKMSG.getBytes());
                fin = new FileInputStream(file);
                int ch = fin.read(bytes, 0, BUFFER_SIZE);
                while (ch != -1) {
                    output.write(bytes, 0, ch);
                    ch = fin.read(bytes, 0, BUFFER_SIZE);
                }
            } else {
                notFount();
            }
        } catch (IOException e) {
            notFount();
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void write(String msg) {
        try {
            output.write(msg.getBytes());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    private void notFount() {
        try {
            output.write(Constant.NOFOUNTMSG.getBytes());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
