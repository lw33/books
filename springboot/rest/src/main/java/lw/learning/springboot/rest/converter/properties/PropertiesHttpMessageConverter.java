package lw.learning.springboot.rest.converter.properties;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * @Author lw
 * @Date 2019-02-18 16:15:20
 **/
public class PropertiesHttpMessageConverter extends AbstractGenericHttpMessageConverter<Properties> {

    public PropertiesHttpMessageConverter() {
        // 设置支持的 MediaType
        super(new MediaType("text", "properties"));
    }

    @Override
    protected void writeInternal(Properties properties, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        Charset charset = getCharset(outputMessage.getHeaders());
        OutputStream out = outputMessage.getBody();
        OutputStreamWriter writer = new OutputStreamWriter(out, charset);
        properties.store(writer, "PropertiesHttpMessageConverter.writeInternal");
    }

    @Override
    protected Properties readInternal(Class<? extends Properties> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        HttpHeaders headers = inputMessage.getHeaders();
        Charset charset = getCharset(headers);
        Properties properties = new Properties();
        InputStreamReader reader = new InputStreamReader(inputMessage.getBody(), charset);
        properties.load(reader);
        return properties;
    }

    @Override
    public Properties read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return read(null, inputMessage);
    }

    public static Charset getCharset(HttpHeaders httpHeaders) {
        MediaType contentType = httpHeaders.getContentType();
        Charset charset = contentType.getCharset();
        return charset == null ? Charset.forName("utf-8") : charset;
    }
}
