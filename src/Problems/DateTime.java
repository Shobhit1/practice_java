package Problems;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by shobhitagarwal on 10/31/16.
 */
public class DateTime {
    public static void main(String[] args) {
        String testString = "2016-02-01T21:13:59Z";
        System.out.println(testString);
        SimpleDateFormat date = new SimpleDateFormat(testString);
        System.out.println(date);
    }
}œ
