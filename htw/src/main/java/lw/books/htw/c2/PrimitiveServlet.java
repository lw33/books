package lw.books.htw.c2;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author lw
 * @Date 2018-11-30 14:23:13
 **/
public class PrimitiveServlet implements Servlet {

    @Override
    public void init(ServletConfig config) throws ServletException {

        System.out.println("PrimitiveServlet.init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        System.out.println("from service");
        PrintWriter out = res.getWriter();
        out.println("Hello. Java");
        out.print(" fff and lll");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

        System.out.println("PrimitiveServlet.destroy");
    }
}
