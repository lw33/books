package lw.learning.springboot.webmvc.servlet.support;

import lw.learning.springboot.webmvc.config.DispatcherServletConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Author lw
 * @Date 2019-02-17 11:41:53
 **/
public class DefaultDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override // web.xml
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override // DispatcherServlet
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{DispatcherServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

