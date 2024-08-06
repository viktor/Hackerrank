package org.hackerrank.weekly;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeConversion {

    public static String timeConversion(String s) {
        DateTimeFormatter dt12h = DateTimeFormatter.ofPattern("hh:mm:ssa");
        DateTimeFormatter dt24h = DateTimeFormatter.ofPattern("HH:mm:ss");
        return LocalTime.from(dt12h.parse(s)).format(dt24h);
    }

}
