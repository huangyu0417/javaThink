package com.hy.think.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * desc:java8中时间日期API示例
 * @author hy
 * @version 1.0
 * @Created on 2018/2/5 11:21
 */
public class DateTimeAPI {

    public static void main(String[] args){
        nowDate();
        nowMonthDay();
        nowTime();
        current();
        localDateTime();
        fomatter();
    }

    static void nowDate() {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println(now.minus(365 << 1,ChronoUnit.DAYS));
    }


    static void nowMonthDay() {
        MonthDay monthDay = MonthDay.now();
        System.out.println(monthDay);
    }


    static void nowTime() {
        LocalTime time = LocalTime.now();
        System.out.println(time);
        System.out.println(time.plus(24, ChronoUnit.MINUTES));
    }

    static void current() {
        Clock clock = Clock.systemDefaultZone();
        Clock utc = Clock.systemUTC();
        System.out.println(System.currentTimeMillis());
        System.out.println("utc = " + utc.millis());
        System.out.println("clock = " + clock.millis());
    }


    static void localDateTime() {
        System.out.println(LocalDateTime.now());
    }


    static void fomatter() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        now.format(formatter);
        System.out.println(formatter.format(now));
    }

}
