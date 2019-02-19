package lw.learning.springboot.view.template.engine;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author lw
 * @Date 2019-02-17 15:28:49
 **/
public class ThymeleafEngineBootstrap {

    public static void main(String[] args) throws IOException {
        // 构建引擎
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        // 创建渲染上下文
        Context context = new Context();
        context.setVariable("message", "Hello,World");
        // 模板的内容
        //String content = "<p th:text=\"${message}\">!!!</p>";
        ResourceLoader resourceLoader = new DefaultResourceLoader();

        Resource resource = resourceLoader.getResource("classpath:/templates/thymeleaf/hello.html");

        File file = resource.getFile();
        FileInputStream fileInputStream = new FileInputStream(file);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        IOUtils.copy(fileInputStream, outputStream);
        fileInputStream.close();

        String content = outputStream.toString();
        // 渲染（处理）结果
        String result = templateEngine.process(content, context);
        // 输出渲染（处理）结果
        System.out.println(result);
    }
}
