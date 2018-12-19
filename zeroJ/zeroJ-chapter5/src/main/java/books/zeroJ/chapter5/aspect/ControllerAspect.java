package books.zeroJ.chapter5.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.annotation.Aspect;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.proxy.AspectProxy;

import java.lang.reflect.Method;

/**
 * @Author lw
 * @Date 2018-12-17 17:16:54
 **/
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {

    private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);
    private long begin;

    @Override
    protected void before(Class<?> targetClass, Method targetMethod, Object[] methodParams) {
        logger.debug("-----------------begin--------------");
        logger.debug(String.format("class: %s", targetClass.getName()));
        logger.debug(String.format("method: %s", targetMethod.getName()));
        begin = System.currentTimeMillis();
    }

    @Override
    protected void after(Class<?> targetClass, Method targetMethod, Object[] methodParams) {
        logger.debug(String.format("times: %dms", System.currentTimeMillis() - begin));
        logger.debug("------------------end-----------------");
    }
}
