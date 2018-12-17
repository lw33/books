package org.smart4j.framework.proxy;

/**
 * @Author lw
 * @Date 2018-12-16 16:38:13
 **/
public interface Proxy {
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
