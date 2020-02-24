package set1000.set1300.set1360.p1361;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

public class Solution {
    public int daysBetweenDates(String date1, String date2) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date a = format.parse(date1);
            Date b = format.parse(date2);

            long res = DAYS.between(a.toInstant(), b.toInstant());

            return Math.abs((int) res);
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
