package org.smart4j.framework.bean;

import org.smart4j.framework.util.CastUtil;

import java.util.List;
import java.util.Map;

/**
 * @Author lw
 * @Date 2018-12-13 12:12:43
 **/
public class Param {

    private Map<String, Object> paramMap;
    private List<FormParam> formParamList;
    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public Map<String, Object> getMap() {
        return paramMap;
    }

    public long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }
   /* *//**
     * 获取请求参数映射
     *//*
    public Map<String, Object> getFieldMap() {
        Map<String, Object> fieldMap = new HashMap<String, Object>();
        if (CollectionUtil.isNotEmpty(formParamList)) {
            for (FormParam formParam : formParamList) {
                String fieldName = formParam.getFieldName();
                Object fieldValue = formParam.getFieldValue();
                if (fieldMap.containsKey(fieldName)) {
                    fieldValue = fieldMap.get(fieldName) + StringUtil.SEPARATOR + fieldValue;
                }
                fieldMap.put(fieldName, fieldValue);
            }
        }
        return fieldMap;
    }*/

    @Override
    public String toString() {
        return "Param{" +
                "paramMap=" + paramMap +
                '}';
    }
}
