package org.smart4j.framework.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @Author lw
 * @Date 2018-12-17 16:01:20
 **/
public abstract class AspectProxy implements Proxy{
    private static final Logger logger = LoggerFactory.getLogger(AspectProxy.class);

    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;

        Class<?> targetClass = proxyChain.getTargetClass();
        Method targetMethod = proxyChain.getTargetMethod();
        Object[] methodParams = proxyChain.getMethodParams();
        begin();
        try {
            if (intercept(targetClass, targetMethod, methodParams)) {
                before(targetClass, targetMethod, methodParams);
                result = proxyChain.doProxyChain();
                after(targetClass, targetMethod, methodParams);
            } else {
                result = proxyChain.doProxyChain();
            }
        } catch (Exception e) {
            logger.error("proxy failure", e);
            error(targetClass, targetMethod, methodParams, e);
            throw e;
        } finally {
            end();
        }
        
        return result;
    }

    protected void before(Class<?> targetClass, Method targetMethod, Object[] methodParams) {

    }

    protected void after(Class<?> targetClass, Method targetMethod, Object[] methodParams) {

    }

    protected  void end(){

    }

    protected void error(Class<?> targetClass, Method targetMethod, Object[] methodParams, Exception e){

    }

    protected boolean intercept(Class<?> targetClass, Method targetMethod, Object[] methodParams){
        return true;
    }

    protected void begin() {

    }
}
