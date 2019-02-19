package lw.learning.springboot.view.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.io.File;

/**
 * @Author lw
 * @Date 2019-02-17 21:29:00
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorParameter(true)
        .favorPathExtension(true);
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setOrder(Ordered.LOWEST_PRECEDENCE - 10);
        viewResolver.setContentType("text/xml;charset=UTF-8");
        return viewResolver;
    }

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer() {

        return factory -> factory.addContextCustomizers(context -> {
            String relativePath = "view/src/main/webapp";
            File docBaseFile = new File(relativePath);
            if(docBaseFile.exists()) { // 路径是否存在
                // 解决 Maven 多模块 JSP 无法读取的问题
                context.setDocBase(docBaseFile.getAbsolutePath());
            }
        });
    }
}
