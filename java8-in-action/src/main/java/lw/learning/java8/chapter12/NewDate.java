package lw.learning.java8.chapter12;

import org.junit.Test;

import java.time.*;
import java.time.chrono.HijrahDate;
import java.time.chrono.JapaneseDate;
import java.time.chrono.MinguoDate;
import java.time.chrono.ThaiBuddhistDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * @Author lw
 * @Date 2018-12-31 20:40:04
 **/
public class NewDate {

    @Test
    public void test1() {
        LocalDate date = LocalDate.of(2018, 12, 31);
        System.out.println(date.getYear());
        System.out.println(date.getMonth().getValue());
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getDayOfWeek().getValue());
        System.out.println(date.getDayOfYear());
        System.out.println(LocalDate.now());
        System.out.println(date.isLeapYear());
        int year = date.get(ChronoField.YEAR);
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);
        System.out.println(year + "-" + month + "-" + day);
    }

    @Test
    public void test2() {
        LocalTime time = LocalTime.of(13, 23, 32);
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());
    }

    @Test
    public void test3() {
        LocalDateTime dt1 = LocalDateTime.of(2018, 12, 31, 13, 12, 13);
        System.out.println(dt1);
        LocalDate date = LocalDate.of(2018, 12, 31);
        LocalTime time = LocalTime.of(13, 23, 32);
        LocalDateTime dt2 = date.atTime(time);
        LocalDateTime dt3 = time.atDate(date);
        LocalDateTime dt4 = LocalDateTime.of(date, time);
        System.out.println(dt2);
        System.out.println(dt3);
        System.out.println(dt4);
    }

    @Test
    public void test4() {
        System.out.println(Instant.ofEpochSecond(3, 1000000000000000000l));
        System.out.println(Instant.now());
        System.out.println(Instant.MAX);
        System.out.println(Instant.MIN);
    }

    @Test
    public void test5() {
        System.out.println(Duration.between(LocalTime.of(14, 1, 1), LocalTime.of(18, 1, 1)).getSeconds());
        System.out.println(Duration.between(LocalDateTime.now(), LocalDateTime.now()).getNano());
        LocalDate date = LocalDate.of(2018, 2, 1);
        System.out.println(Period.between(date, LocalDate.now()).getMonths());
    }

    @Test
    public void test6() {
        System.out.println(ThaiBuddhistDate.now());
        System.out.println(MinguoDate.now());
        System.out.println(JapaneseDate.now());
        System.out.println(HijrahDate.now());
    }

    @Test
    public void test7() {
        LocalDate date = LocalDate.now();
        LocalDate nextDay = date.with(temporal -> {
            DayOfWeek dow = date.getDayOfWeek();
            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
            else if (dow == DayOfWeek.SATURDAY) dayToAdd = 2;
            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        });
        System.out.println(date);
        System.out.println(nextDay);
    }

    @Test
    public void test8() {
        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();
        System.out.println(time.format(DateTimeFormatter.ISO_TIME));
        String format = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(format);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String format1 = date.format(dateTimeFormatter);
        LocalDate parse = LocalDate.parse(format1, dateTimeFormatter);
        System.out.println(parse);
    }

    @Test
    public void test9() {
        LocalDate date = LocalDate.of(2018, Month.DECEMBER, 31);
        ZoneId rome = ZoneId.of("Europe/Rome");
        ZonedDateTime zdt1 = date.atStartOfDay(rome);
        System.out.println(Instant.now().atZone(rome));
        System.out.println(zdt1);
    }
}
