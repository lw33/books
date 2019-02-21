package lw.learning.springboot.rest.support;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * @Author lw
 * @Date 2019-02-18 16:13:30
 **/
public class PropertiesHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType() == Properties.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        MediaType contentType = MediaType.parseMediaType(request.getContentType());
        Charset charset = contentType.getCharset();
        charset = charset == null ? Charset.forName("utf-8") : charset;
        Properties properties = new Properties();
        InputStreamReader reader = new InputStreamReader(request.getInputStream(), charset);
        properties.load(reader);
        return properties;
    }
}
