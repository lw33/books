package lw.learning.java8.chapter14;

/**
 * @Author lw
 * @Date 2018-12-31 18:27:41
 **/
public class Tree {

    public String key;
    public int val;
    public Tree left, right;

    public Tree(String key, int val, Tree left, Tree right) {
        this.key = key;
        this.val = val;
        this.left = left;
        this.right = right;
    }


}
