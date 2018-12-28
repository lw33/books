package lw.learning.monitortuning.chapter8;

/**
 * @Author lw
 * @Date 2018-12-27 21:02:13
 **/
public class Solt {
    public static void main(String[] args) {
        {
            byte[] placeHolder = new byte[1024 * 1024 * 64];
        }
        int a = 0;
        System.gc();
    }
}
