package net.commons.core;

/**
 * 公共数据封装
 * 定义数据类型与长度
 * @Author lw
 * @Date 2019-02-10 18:49:44
 **/
public class Packet {

    private byte type;
    private int length;

    public byte type() {
        return type;
    }

    public int length() {
        return length;
    }

}
