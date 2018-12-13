package org.smart4j.framework.bean;

/**
 * 返回数据对象
 * @Author lw
 * @Date 2018-12-13 20:32:22
 **/
public class Data {

    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}
