package lw.learning.java8.chapter13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-31 17:38:52
 **/
public class Subsets {

    public static List<List<Integer>> subsets(List<Integer> list) {
        if (list.isEmpty()) {

            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            return ans;
        }

        Integer first = list.get(0);
        List<Integer> rest = list.subList(1, list.size());
        List<List<Integer>> subans = subsets(rest);
        List<List<Integer>> subans2 = insertAll(first, subans);
        return concat(subans, subans2);
    }

    private static List<List<Integer>> concat(List<List<Integer>> subans, List<List<Integer>> subans2) {
        List<List<Integer>> res = new ArrayList<>(subans);
        res.addAll(subans2);
        return res;
    }

    private static List<List<Integer>> insertAll(Integer first, List<List<Integer>> subans) {
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> suban : subans) {
            ArrayList<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(suban);
            res.add(copyList);
        }
        return res;
    }
}
