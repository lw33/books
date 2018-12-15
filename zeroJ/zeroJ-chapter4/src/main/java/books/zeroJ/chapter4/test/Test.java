package books.zeroJ.chapter4.test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2018-12-15 14:11:34
 **/
public class Test {

    long start = 0;
    long end = 0;
    public void start() {
        start = System.currentTimeMillis();
    }

    public void end() {
        end = System.currentTimeMillis();
    }

    public long duration() {
        return end - start;
    }
    
    @org.junit.Test
    public void test() {
        int n = 10000;
        int times = 3;
        long[][] duration = new long[times][2];
        for (int j = 0; j < times; j++) {
            start();
            for (int i = 0; i < n; i++) {
                Hello proxy = new DynamicProxy(new HelloImpl()).getProxy();
                proxy.hello();
            }
            end();
            long duration1 = duration();
            duration[j][0] = duration1;
            start();
            for (int i = 0; i < n; i++) {
                Hello proxy = new CGLibProxy().getProxy(HelloImpl.class);
                proxy.hello();
            }
            end();
            long duration2 = duration();
            duration[j][1] = duration2;
        }
        System.out.println(Arrays.deepToString(duration));
    }
}
