package lw.learning.java8.chapter5;

import java.util.*;

/**
 * @Author lw
 * @Date 2018-12-28 22:11:23
 **/
public class PuttingIntoPractice {


    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        System.out.println("\n=========================================================\n");

        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);

        System.out.println("\n=========================================================\n");

        List<Transaction> tmp = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getYear() == 2011) {
                tmp.add(transaction);
            }
        }
        Collections.sort(tmp, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                return Integer.compare(o1.getValue(), o2.getValue());
            }
        });

        for (Transaction transaction : tmp) {
            System.out.println(transaction);
        }

        System.out.println("\n=========================================================\n");

        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        System.out.println("\n=========================================================\n");

        transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> "Cambridge".equals(t.getCity()))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);

        System.out.println("\n=========================================================\n");

        System.out.println(transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2));

        System.out.println("\n=========================================================\n");

        Optional<Transaction> any = transactions.stream()
                .filter(transaction -> "Milan".equals(transaction.getTrader().getCity()))
                .findAny();
        System.out.println(any);

        System.out.println("\n=========================================================\n");

        System.out.println(transactions.stream()
                                        .anyMatch(transaction -> "Milan"
                                        .equals(transaction.getTrader().getCity())));

        System.out.println("\n=========================================================\n");

        System.out.println(transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .reduce(0, Integer::sum));

        System.out.println("\n=========================================================\n");

        System.out.println(transactions.stream()
                .max(Comparator.comparingInt(Transaction::getValue)));

        System.out.println(transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max));

        System.out.println("\n=========================================================\n");

        System.out.println(transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue)));

        System.out.println(transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min));

        System.out.println("\n=========================================================\n");


    }
}
