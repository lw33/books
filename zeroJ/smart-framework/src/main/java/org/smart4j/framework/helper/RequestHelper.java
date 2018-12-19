package org.smart4j.framework.helper;

import org.smart4j.framework.bean.FormParam;
import org.smart4j.framework.bean.Param;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.CodecUtil;
import org.smart4j.framework.util.StreamUtil;
import org.smart4j.framework.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-19 16:44:40
 **/
public class RequestHelper {

    public static Param crateParam(HttpServletRequest request) throws IOException {
        List<FormParam> formParamList = new ArrayList<>();
        parseParameterNames(request, formParamList);
        parseInputStream(request, formParamList);
        return new Param(formParamList);
    }

    /**
     * 获取 post 或者 get 参数
     * @param request
     * @param formParamList
     */
    private static void parseParameterNames(HttpServletRequest request, List<FormParam> formParamList) {
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String fieldName = parameterNames.nextElement();
            String[] fieldValues = request.getParameterValues(fieldName);
            if (ArrayUtil.isNotEmpty(fieldValues)) {
                Object fieldValue;
                if (fieldValues.length == 1) {
                    fieldValue = fieldValues[0];
                } else {
                    StringBuilder sb = new StringBuilder();
                    int i = 0;
                    for (; i < fieldValues.length - 1; i++) {
                        sb.append(fieldValues[i] + StringUtil.SEPARATOR);
                    }
                    sb.append(fieldValues[i]);
                    fieldValue = sb.toString();
                }
                formParamList.add(new FormParam(fieldName, fieldValue));
            }
        }
    }

    /**
     * 从流中获取参数
     * @param request
     * @param formParamList
     * @throws IOException
     */
    public static void parseInputStream(HttpServletRequest request, List<FormParam> formParamList) throws IOException {
        String body = CodecUtil.decodeURL(StreamUtil.getString(request.getInputStream()));
        if (StringUtil.isNotEmpty(body)) {
            String[] kvs = StringUtil.splitString(body, "&");
            if (ArrayUtil.isNotEmpty(kvs)) {
                for (String kv : kvs) {
                    String[] array = StringUtil.splitString(kv, "=");
                    if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
                        String fieldName = array[0];
                        String fieldValue = array[1];
                        formParamList.add(new FormParam(fieldName, fieldValue));
                    }
                }
            }
        }
    }
}
