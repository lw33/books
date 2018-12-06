package lw.books.htw.c16;

import lw.books.htw.utils.Constants;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

/**
 * @Author lw
 * @Date 2018-12-05 18:52:16
 **/
public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        URL[] urls = new URL[1];
        URLStreamHandler streamHandler = null;
        File classPath = new File(Constants.WEB_ROOT);
        String repository = new URL("file", null, classPath.getCanonicalPath() + File.separator).toString();
        urls[0] = new URL(null, repository, streamHandler);
        ClassLoader classLoader = null;
        URLClassLoader loader = new URLClassLoader(urls, null);

        Class<?> primitiveServlet = loader.loadClass("lw.books.htw.c16.PrimitiveServlet");

        Object o = primitiveServlet.newInstance();
        //PrimitiveServlet p = (PrimitiveServlet) o;
        System.out.println(o.getClass());
        System.out.println(o.getClass().getClassLoader());
        //lw.books.htw.c16.PrimitiveServlet primitiveServlet1 = (lw.books.htw.c16.PrimitiveServlet) o;
        Field string = primitiveServlet.getField("string");
        Method getServletConfig = primitiveServlet.getMethod("getServletConfig");
        Object o1 = string.get(o);
        System.out.println(o1);
        getServletConfig.invoke(o);
        System.out.println(o1.getClass().getClassLoader());
    }
}
