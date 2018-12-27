package lw.learning.monitortuning.chapter8;

/**
 * @Author lw
 * @Date 2018-12-27 00:29:16
 **/
public class Loop {

    public static void main(String[] args) {

    }

    /*
    stack=1, locals=0, args_size=0
    0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
    3: invokevirtual #3                  // Method java/io/PrintStream.println:()V
    6: goto          0

     */
    public static void f1() {
        for (; ; ) {
            System.out.println();
        }
    }

    /*
      stack=1, locals=0, args_size=0
      0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
      3: invokevirtual #3                  // Method java/io/PrintStream.println:()V
      6: goto          0

     */
    public static void f2() {
        while (true) {
            System.out.println();
        }
    }

    /*
      stack=4, locals=5, args_size=0
         0: iconst_3
         1: newarray       int
         3: dup
         4: iconst_0
         5: iconst_1
         6: iastore
         7: dup
         8: iconst_1
         9: iconst_2
        10: iastore
        11: dup
        12: iconst_2
        13: iconst_3
        14: iastore
        15: astore_0
        16: aload_0
        17: astore_1
        18: aload_1
        19: arraylength
        20: istore_2
        21: iconst_0
        22: istore_3
        23: iload_3
        24: iload_2
        25: if_icmpge     39
        28: aload_1
        29: iload_3
        30: iaload
        31: istore        4
        33: iinc          3, 1
        36: goto          23
        39: return
     */
    public static void f3() {
        int[] nums = {1, 2, 3};
        for (int num : nums) {

        }
    }

    /*
       stack=4, locals=2, args_size=0
         0: iconst_3
         1: newarray       int
         3: dup
         4: iconst_0
         5: iconst_1
         6: iastore
         7: dup
         8: iconst_1
         9: iconst_2
        10: iastore
        11: dup
        12: iconst_2
        13: iconst_3
        14: iastore
        15: astore_0
        16: iconst_0
        17: istore_1
        18: iload_1
        19: aload_0
        20: arraylength
        21: if_icmpge     30
        24: iinc          1, 1
        27: goto          18
        30: return
     */
    public static void f4() {
        int[] nums = {1, 2, 3};
        for (int i = 0; i < nums.length; i++) {

        }
    }
}
