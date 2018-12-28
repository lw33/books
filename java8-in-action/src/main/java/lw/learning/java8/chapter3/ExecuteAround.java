package lw.learning.java8.chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author lw
 * @Date 2018-12-27 22:58:00
 **/
public class ExecuteAround {


    public static void main(String[] args) throws IOException {
        String s1 = processFile(BufferedReader::readLine);
        System.out.println(s1);
        String s2 = processFile(b -> b.readLine() + b.readLine());
        System.out.println(s2);
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException{
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(".gitignore"))) {
            return p.process(bufferedReader);
        }
    }

    @FunctionalInterface
    interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }
}
