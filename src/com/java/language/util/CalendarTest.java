package com.java.language.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by bod on 1/12/2015.
 */
public class CalendarTest {
    public static void main(String[] strings) {
        Date date = new Date(); // your date
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day_of_month = cal.get(Calendar.DAY_OF_MONTH);
        int day_of_week = cal.get(Calendar.DAY_OF_WEEK);
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        System.out.println(cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US));

        System.out.println(year + ", " + month + ", " + day_of_month + ", " + day_of_week + ", " + hour + ", " + minute + ", " + second);

        String a = "AMERICA_LOS_ANGELES";
        String b = "" + cal.getTimeZone().getID().replace('/', '_').toUpperCase();
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.equals(b));
    }
}
