package lw.books.htw.c2;

/**
 * @Author lw
 * @Date 2018-11-30 21:04:09
 **/
public class StaticResourceProcessor {

    public static void process(Request request, Response response) {
        response.sendStaticResource();
    }
}
