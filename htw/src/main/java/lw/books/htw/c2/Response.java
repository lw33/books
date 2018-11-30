package lw.books.htw.c2;

import com.sun.org.apache.bcel.internal.generic.FNEG;
import lw.books.htw.utils.Constant;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.*;
import java.util.Locale;

/**
 * @Author lw
 * @Date 2018-11-30 20:47:11
 **/
public class Response implements ServletResponse {

    private Request request;
    private OutputStream output;
    private PrintWriter printWriter;

    public Response(OutputStream output) {
        this.output = output;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() {
        FileInputStream fin = null;
        try {
            File file = new File(Constant.WEB_ROOT, request.getUri());
            if (file.exists()) {
                fin = new FileInputStream(file);
                byte[] buffer = new byte[Constant.SMALL_BUFFER_SIZE];
                output.write(Constant.OKMSG.getBytes());
                int i = fin.read(buffer);

                while (i != -1) {
                    output.write(buffer, 0, i);
                    i = fin.read(buffer);
                }
            } else {
                output.write(Constant.NOFOUNTMSG.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
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
    @Override
    public String getCharacterEncoding() {
        return null;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return null;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        printWriter = new PrintWriter(output, true);
        return printWriter;
    }

    @Override
    public void setCharacterEncoding(String charset) {

    }

    @Override
    public void setContentLength(int len) {

    }

    @Override
    public void setContentLengthLong(long len) {

    }

    @Override
    public void setContentType(String type) {

    }

    @Override
    public void setBufferSize(int size) {

    }

    @Override
    public int getBufferSize() {
        return 0;
    }

    @Override
    public void flushBuffer() throws IOException {

    }

    @Override
    public void resetBuffer() {

    }

    @Override
    public boolean isCommitted() {
        return false;
    }

    @Override
    public void reset() {

    }

    @Override
    public void setLocale(Locale loc) {

    }

    @Override
    public Locale getLocale() {
        return null;
    }
}
