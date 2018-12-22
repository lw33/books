package lw.learning.concurrency;

import lw.learning.concurrency.example.threadlocal.RequestHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author lw
 * @Date 2018-12-22 01:20:04
 **/
public class HttpInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("HttpInterceptor.preHandle");
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("HttpInterceptor.afterCompletion");
        RequestHolder.remove();
    }
}
