package lw.learning.java8.chapter7;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @Author lw
 * @Date 2018-12-29 22:54:26
 **/
public class WordCount {

    public static final String SENTENCE =
            " Nel   mezzo del cammin  di nostra  vita " +
                    "mi  ritrovai in una  selva oscura" +
                    " che la  dritta via era   smarrita ";


    public int countWordsIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace)
                    counter++;
                lastSpace = false;
            }
        }
        return counter;
    }

    public static class WordCounter {
        private final int counter;
        private final boolean lastSpace;

        public WordCounter(int counter, boolean lastSpace) {
            this.counter = counter;
            this.lastSpace = lastSpace;
        }

        public WordCounter accumulate(Character c) {
            if (Character.isWhitespace(c)) {
                return lastSpace ? this : new WordCounter(counter, true);
            } else {
                return lastSpace ? new WordCounter(counter + 1, false) : this;
            }

        }

        public WordCounter combinate(WordCounter wordCounter) {
            return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
        }

        public int getCounter() {
            return counter;
        }
    }

    public static int countWords(Stream<Character> stream) {
        WordCounter reduce = stream.reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combinate);
        return reduce.getCounter();
    }
    public static void main(String[] args) {
        Stream<Character> characterStream = IntStream.range(0, SENTENCE.length())
                .mapToObj(SENTENCE::charAt);
        WordCounter reduce = characterStream.parallel().reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combinate);
        System.out.println(reduce.getCounter());

        WordCounterSpliterator wordCounterSpliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream = StreamSupport.stream(wordCounterSpliterator, true);
        System.out.println(countWords(stream));
    }
}
