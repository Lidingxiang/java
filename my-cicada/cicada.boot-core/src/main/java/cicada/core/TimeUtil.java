package cicada.core;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
    public TimeUtil() {
    }

    public static long currentTimeMillis() {
        long result = System.currentTimeMillis();
        return result;
    }

    public static String currentDate() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = simpleDateFormat.format(date);
        return result;
    }

    public static String currentDateModify(int period) {
        Date date1 = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        calendar.add(13, period);
        Date data2 = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = simpleDateFormat.format(data2);
        return result;
    }

    public static long date2Stamp(String date) throws ParseException {
        long result = date2Stamp(date, "yyyy-MM-dd HH:mm:ss");
        return result;
    }

    public static long date2Stamp(String date, String format) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date time = dateFormat.parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        long result = cal.getTimeInMillis();
        return result;
    }

    public static String stamp2Date(Long smamp, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date = new Date(smamp.longValue());
        String result = simpleDateFormat.format(date);
        return result;
    }

    public static String stamp2Date(Long smamp) {
        String result = stamp2Date(smamp, "yyyy-MM-dd HH:mm:ss");
        return result;
    }
}
