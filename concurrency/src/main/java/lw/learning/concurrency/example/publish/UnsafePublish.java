package lw.learning.concurrency.example.publish;

import lw.learning.concurrency.annotation.NotThreadSafe;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2018-12-21 21:17:38
 **/
@NotThreadSafe
public class UnsafePublish {

    private String[] states = {"a", "b", "c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        String[] states = unsafePublish.getStates();
        System.out.println(Arrays.toString(states));
        states[0] = "java";
        System.out.println(Arrays.toString(states));
    }
}
