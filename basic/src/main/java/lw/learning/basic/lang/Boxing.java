package lw.learning.basic.lang;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-02-05 21:04:34
 **/
public class Boxing {

    public static void main(String[] args) {
        System.out.println(new Integer(1) == new Integer(1));
        System.out.println(Integer.valueOf(1) == Integer.valueOf(1));
        List<Integer> list = Arrays.asList(1);
        List<Integer> list1 = list.subList(1, list.size());
        System.out.println(list);
        System.out.println(list1);
    }

    @Test
    public void test1() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        List list = integers;
        list.add("java");
        System.out.println(list);
    }
}
