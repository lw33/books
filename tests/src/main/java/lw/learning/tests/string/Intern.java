package lw.learning.tests.string;

/**
 * @Author lw
 * @Date 2019-01-14 14:36:55
 **/
public class Intern {
    public static void main(String[] args) {
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2);
        System.out.println(s1 == s1.intern());
        System.out.println(s2 == s2.intern());
        System.out.println("aaa" == s2.intern());
        System.out.println(s1.intern() == s2.intern());
        String s3 = s1.intern();
        String s4 = s2.intern();
        System.out.println();

        Integer.bitCount(127);

        String s = ",a,b,c,,";
        String[] split = s.split(",");
        System.out.println(split.length);

    }
}
