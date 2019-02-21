package lw.learning.spring.servlet.support;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Author lw
 * @Date 2019-02-18 20:36:18
 **/
@ComponentScan(basePackages = "lw.learning.spring.servlet.controller")
public class DefaultAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{getClass()};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
