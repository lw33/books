package org.smart4j.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.bean.Data;
import org.smart4j.framework.bean.Handler;
import org.smart4j.framework.bean.Param;
import org.smart4j.framework.bean.View;
import org.smart4j.framework.helper.*;
import org.smart4j.framework.util.JsonUtil;
import org.smart4j.framework.util.ReflectionUtil;
import org.smart4j.framework.util.StringUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Author lw
 * @Date 2018-12-13 12:19:31
 **/
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // initialize
        HelperLoader.init();
        ServletContext servletContext = servletConfig.getServletContext();
        ServletRegistration jsp = servletContext.getServletRegistration("jsp");
        jsp.addMapping(ConfigHelper.getAppJspPath() + "*");
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");
        UploadHelper.init(servletContext);

        logger.info("app start");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestMethod = req.getMethod().toLowerCase();
        String requestPath = req.getPathInfo();
        if (requestPath.equals("/favicon.ico")) {
            return;
        }
        Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
        if (handler != null) {
            Class<?> controllerClass = handler.getControllerClass();
            Object controllerBean = BeanHelper.getBean(controllerClass);
            Method actionMethod = handler.getActionMethod();
            // 获取方法参数个数
            int parameterCount = actionMethod.getParameterCount();
            Object result;
            // 通过判断方法参数个数决定否传入参数
            if (parameterCount > 0) {
                Param param;
                if (UploadHelper.isMultipart(req)) {
                    param = UploadHelper.createParam(req);
                } else {
                    param = RequestHelper.crateParam(req);
                }
                result = ReflectionUtil.invokeMethod(controllerBean, actionMethod, param);
            } else {
                result = ReflectionUtil.invokeMethod(controllerBean, actionMethod);
            }
            if (result instanceof View) {
                handleViewResult(req, resp, (View) result);
            } else if (result instanceof Data) {
                handleDataResult(resp, (Data) result);
            }
        }

    }

    /**
     * 处理视图
     * @param req
     * @param resp
     * @param result
     * @throws IOException
     * @throws ServletException
     */
    private void handleViewResult(HttpServletRequest req, HttpServletResponse resp, View result) throws IOException, ServletException {
        String path = result.getPath();
        if (StringUtil.isNotEmpty(path)) {
            if (path.startsWith("/")) {
                resp.sendRedirect(req.getContextPath() + path);
            } else {
                Map<String, Object> model = result.getModel();
                model.forEach(req::setAttribute);
                req.getRequestDispatcher(ConfigHelper.getAppJspPath() + path).forward(req, resp);
            }
        }
    }

    /**
     * 处理数据
     * @param resp
     * @param result
     * @throws IOException
     */
    private void handleDataResult(HttpServletResponse resp, Data result) throws IOException {
        Object model = result.getModel();
        if (model != null) {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter writer = resp.getWriter();
            String json = JsonUtil.toJson(model);
            writer.write(json);
            writer.flush();
            writer.close();
        }
    }
}
