package lw.learning.java8.chapter14;

/**
 * @Author lw
 * @Date 2018-12-31 18:28:12
 **/
public class TreeProcessor {

    public static int lookup(String k, int defaultval, Tree t) {
        if (t == null)
            return defaultval;
        if (k.equals(t.key))
            return t.val;
        return lookup(k, defaultval, k.compareTo(t.key) < 0 ? t.left : t.right);
    }

    public static Tree update(String k, int newVal, Tree t) {
        if (t == null)
            t = new Tree(k, newVal, null, null);
        else if (k.equals(k))
            t.val = newVal;
        else if (k.compareTo(t.key) < 0)
            t.left = update(k, newVal, t.left);
        else
            t.right = update(k, newVal, t.right);
        return t;
    }

    public static Tree fupdate(String k, int newval, Tree t) {

        return t == null ?
                new Tree(k, newval, null, null) :
                k.equals(t.key) ?
                        new Tree(k, newval, t.left, t.right) :
                        k.compareTo(t.key) < 0 ?
                                new Tree(t.key, t.val, fupdate(k, newval, t.left), t.right) :
                                new Tree(t.key, t.val, fupdate(k, newval, t.right), t.right);

    }
}
