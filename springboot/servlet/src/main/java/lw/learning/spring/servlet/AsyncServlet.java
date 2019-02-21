package lw.learning.spring.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static lw.learning.spring.servlet.controller.HelloAsyncController.print;

/**
 * @Author lw
 * @Date 2019-02-19 11:01:20
 **/
@WebServlet(name = "asyncServlet", asyncSupported = true, urlPatterns = "/as")
public class AsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        if (req.isAsyncSupported()) {

            AsyncContext asyncContext = req.startAsync();
            asyncContext.addListener(new AsyncListener() {
                @Override
                public void onComplete(AsyncEvent event) {
                    print("onComplete");
                }

                @Override
                public void onTimeout(AsyncEvent event) {
                    print("onTimeout");
                }

                @Override
                public void onError(AsyncEvent event) {
                    print("onError");
                }

                @Override
                public void onStartAsync(AsyncEvent event) {
                    print("onStartAsync");
                }
            });
        }

        print("as hello");
    }
}
