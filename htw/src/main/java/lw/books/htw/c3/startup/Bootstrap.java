package lw.books.htw.c3.startup;

import lw.books.htw.c3.connector.HttpConnector;

/**
 * @Author lw
 * @Date 2018-12-01 12:33:26
 **/
public class Bootstrap {

    public static void main(String[] args) {

        HttpConnector connector = new HttpConnector();
        connector.start();
    }
}
