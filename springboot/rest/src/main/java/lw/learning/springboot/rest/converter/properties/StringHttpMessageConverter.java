package lw.learning.springboot.rest.converter.properties;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

/**
 * @Author lw
 * @Date 2019-02-18 16:15:20
 **/
public class StringHttpMessageConverter extends AbstractGenericHttpMessageConverter<String> {

    public StringHttpMessageConverter() {
        // 设置支持的 MediaType
        super(new MediaType("f", "s"));
    }

    @Override
    protected String readInternal(Class<? extends String> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {

        byte[] buffer = new byte[1024];
        inputMessage.getBody().read(buffer);
        return new String(buffer);
    }

    @Override
    protected void writeInternal(String s, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        outputMessage.getBody().write(s.getBytes());
    }

    public static Charset getCharset(HttpHeaders httpHeaders) {
        MediaType contentType = httpHeaders.getContentType();
        Charset charset = contentType.getCharset();
        return charset == null ? Charset.forName("utf-8") : charset;
    }

    @Override
    public String read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }
}
