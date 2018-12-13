package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.bean.Handler;
import org.smart4j.framework.bean.Request;
import org.smart4j.framework.util.ArrayUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author lw
 * @Date 2018-12-13 00:11:16
 **/
public class ControllerHelper {
    private static final Map<Request, Handler> ACTION_MAP = new HashMap<>();
    static {
        // 获取所有的 controller class
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        // 遍历
        controllerClassSet.forEach(controllerClass -> {
            // 获取 controller 中所有的方法
            Method[] controllerMethods = controllerClass.getDeclaredMethods();
            // 遍历
            for (Method controllerMethod : controllerMethods) {
                // 获取每个被 action 注解的方法
                if (controllerMethod.isAnnotationPresent(Action.class)) {
                    Action action = controllerMethod.getAnnotation(Action.class);
                    String mapping = action.value();
                    // 匹配是否是 url
                    if (mapping.matches("\\w+:/\\w*")) {
                        String[] strings = mapping.split(":");
                        if (ArrayUtil.isNotEmpty(strings) && strings.length == 2) {
                            // 构造 request 与 Handler 映射
                            String requestMethod = strings[0];
                            String requestPath = strings[1];
                            Request request = new Request(requestMethod, requestPath);
                            Handler handler = new Handler(controllerClass, controllerMethod);
                            ACTION_MAP.put(request, handler);
                        }
                    }
                }
            }
        });
    }

    public static Handler getHandler(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }
}
