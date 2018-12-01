package lw.books.htw.c2.v2;

import lw.books.htw.c2.Request;
import lw.books.htw.c2.Response;
import lw.books.htw.utils.Constants;

import javax.servlet.Servlet;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

/**
 * @Author lw
 * @Date 2018-11-30 21:05:58
 **/
public class ServletProcessorV2 {

    public static void process(Request request, Response response) {
        String uri = request.getUri();
        String servletName = uri.substring(uri.lastIndexOf("/") + 1);
        URLClassLoader loader = null;
        try {

            URL[] urls = new URL[1];
            URLStreamHandler streamHandler = null;
            File classPath = new File(Constants.WEB_ROOT);
            String repository = new URL("file", null, classPath.getCanonicalPath() + File.separator).toString();
            urls[0] = new URL(null, repository, streamHandler);
            loader = new URLClassLoader(urls);

        } catch (IOException e) {
            e.printStackTrace();
        }
        Class myClass = null;
        try {
            myClass = loader.loadClass(servletName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Servlet servlet = null;
        try {

            servlet = (Servlet) myClass.newInstance();
            RequestFacade requestFacade = new RequestFacade(request);
            ResponseFacade responseFacade = new ResponseFacade(response);
            servlet.service(requestFacade, responseFacade);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
