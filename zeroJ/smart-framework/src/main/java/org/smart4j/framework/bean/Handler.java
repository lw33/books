package org.smart4j.framework.bean;

import java.lang.reflect.Method;

/**
 * @Author lw
 * @Date 2018-12-13 00:08:26
 **/
public class Handler {

    /**
     * handler 所定义的 controller 的 class
     */
    private Class<?> controllerClass;

    /**
     * handler 所对应的 controller 中的方法
     */
    private Method actionMethod;

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }

}
