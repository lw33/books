package lw.books.htw.c1;

import com.sun.deploy.net.HttpRequest;
import org.apache.catalina.servlet4preview.http.HttpServletRequestWrapper;

import javax.servlet.http.HttpServlet;
import java.io.*;
import java.net.*;

/**
 * @Author lw
 * @Date 2018-11-29 15:30:55
 **/
public class Test {
    
    @org.junit.Test
    public void test() throws IOException {
        Socket f = new Socket("f", 80);
        OutputStream out = f.getOutputStream();
        PrintWriter printWriter = new PrintWriter(out, true);
        printWriter.println("GET / HTTP/1.1");
        printWriter.println("Host: localhost:8080");
        printWriter.println("Connection: Close");
        printWriter.println();
        InputStream inputStream = f.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String read = null;
        while ((read = bufferedReader.readLine()) != null) {
            sb.append(read + "\n");
        }
        System.out.println(sb.toString());
        f.close();
        System.out.println(out);
        System.out.println(inputStream);
    }

    @org.junit.Test
    public void test1() throws UnknownHostException {
        System.out.println(System.getProperty("user.dir"));
        System.out.println(this.getClass().getPackage());
        System.out.println(this.getClass().getResource("Test.class"));
        System.out.println(InetAddress.getLocalHost());
        System.out.println(InetAddress.getByName("f").getHostName());
    }

    @org.junit.Test
    public void test2() throws IOException {
        //testProtocol("http://www.baidu.com");
        URL url = new URL("http://t.cn/E2s1pT2");
        /*InputStream inputStream = url.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String read;
        while ((read = reader.readLine()) != null) {
            System.out.println(read);
        }*/
       /* URLConnection urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);

        OutputStream outputStream = urlConnection.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("GET / HTTP/1.1");
        writer.close();*/
        System.out.println(url.getContent().getClass().getName());

    }

    public void testProtocol(String url) {
        try {
            URL u = new URL(url);
            System.out.println(u.getContent());
            System.out.println(u.getProtocol() + " is supported.");
        } catch (MalformedURLException e) {
            String protocol = url.substring(0, url.indexOf(":"));
            System.out.println(protocol + " is not supported.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
