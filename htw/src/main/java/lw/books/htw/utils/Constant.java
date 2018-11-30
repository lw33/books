package lw.books.htw.utils;

/**
 * @Author lw
 * @Date 2018-11-30 18:16:13
 **/
public interface Constant {
    String WEB_ROOT = "F:\\WorkSpace\\IDEA2018\\books\\htw\\webroot";


    String SHUTDOWN_COMMAND = "/SHUTDOWN";

    int TINY_BUFFER_SIZE = 1024;
    int SMALL_BUFFER_SIZE = 2048;
    int MEDIAN_BUFFER_SIZE = 4096;
    int BIG_BUFFER_SIZE = 8192;

    String NOFOUNTMSG = "HTTP/1.1 404 File Not Found\r\n" +
            "Content-Type: text/html\r\n" +
            "Content-Length: 23\r\n" +
            "\r\n" +
            "<h1>File Not Found</h1>";

    String SHUTDOWNMSG = "HTTP/1.1 200 Shutdown\r\n" +
            "Content-Type: text/html\r\n" +
            "\r\n" +
            "<h1>SHUTDOWN SUCCESS</h1>";

    String OKMSG = "HTTP/1.1 200 ok\r\n" + "\r\n";
}
