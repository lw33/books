package lw.books.htw.c1;

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
    public static String NOFOUNTMSG= "HTTP/1.1 404 File Not Found\r\n" +
            "Content-Type: text/html\r\n" +
            "Content-Length: 23\r\n" +
            "\r\n" +
            "<h1>File Not Found</h1>";

    public static String OKMSG = "HTTP/1.1 200 ok\r\n" + "\r\n";


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
            }

            File file = new File(HttpServer.WEB_ROOT, request.getUri());
            if (file.exists()) {
                output.write(OKMSG.getBytes());
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

    private void notFount() {
        try {
            output.write(NOFOUNTMSG.getBytes());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
