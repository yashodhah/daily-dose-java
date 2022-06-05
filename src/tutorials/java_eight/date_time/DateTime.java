package tutorials.java_eight.date_time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;

public class DateTime {
    public static void main(String[] args) {
//        LocalDate localDate = LocalDate.now();
//        Date date = new Date();
//
//        System.out.println(localDate);
//        System.out.println(date);
//
//        DayOfWeek sunday = LocalDate.parse("2016-06-12").getDayOfWeek();
//        System.out.println(sunday);
//
//        LocalDate initialDate = LocalDate.parse("2007-05-10");
//        LocalDate finalDate = initialDate.plus(Period.ofDays(5));
//
//        System.out.println(finalDate);
//
//        System.out.println(LocalDateTime.now());

        System.out.println(args[2]);
    }

    static Exception print(int i) {
        if (i > 0) {
            return new Exception();
        } else {
            throw new RuntimeException();
        }
    }
}
