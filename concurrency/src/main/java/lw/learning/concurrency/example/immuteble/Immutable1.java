package lw.learning.concurrency.example.immuteble;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.util.List;
import java.util.Set;

/**
 * @Author lw
 * @Date 2018-12-21 22:42:42
 **/
public class Immutable1 {
    private final static List<Integer> list = ImmutableList.of(1, 2, 3);
    private static final Set<Integer> set = ImmutableSet.copyOf(list);
    private static final ImmutableMap<Object, Object> map = ImmutableMap.builder().put(1, 2)
            .put(2, 3)
            .put(3, 4).build();

    public static void main(String[] args) {
        //list.add(1);
        //map.put(1, 2);
        System.out.println(map.get(1));
    }
}
