package lw.learning.tests.test;

import java.nio.ByteBuffer;

/**
 * @Author lw
 * @Date 2018-12-19 16:51:42
 **/
public class Test {

    @org.junit.Test
    public void test1() {
        System.out.println((char)29);
    }


    @org.junit.Test
    public void test() {
        ByteBuffer bytebuffer = ByteBuffer.allocate(256);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append(i);
        }
        bytebuffer.put(sb.toString().getBytes());
        System.out.println(bytebuffer);
    }
}
