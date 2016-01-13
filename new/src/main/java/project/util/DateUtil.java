package project.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期工具类
 */
public class DateUtil {

    /**
     * 当月最后一天
     *
     * @return
     */
    public static String getLastDay(int year, int month) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = new GregorianCalendar();
        ca.set(year, month - 1, 1);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        return format.format(ca.getTime());
    }

    /**
     * 日期加减
     *
     * @param date 日期
     * @param num  加减数量
     * @return Date 加减后日期
     */
    public static Date dateOperation(Date date, Integer num) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, num);
        Date da = cal.getTime();
        return da;
    }

    /**
     * 时间转字符串
     *
     * @param date   日期
     * @param format 格式
     * @return String
     */
    public static String date2str(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 取得当前日期是多少周
     *
     * @param date
     * @return
     */
    public static int getWeekOfYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        /**
         * 设置一年中第一个星期所需的最少天数，例如，如果定义第一个星期包含一年第一个月的第一天，则使用值 1 调用此方法。
         * 如果最少天数必须是一整个星期，则使用值 7 调用此方法。
         **/
        c.setMinimalDaysInFirstWeek(1);
        c.setTime(date);
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 取得当前日期是多少周
     *
     * @param str
     * @param format
     * @return
     */
    public static int getWeekOfYear(String str, String format) {
        try {
            Calendar c = Calendar.getInstance();
            c.setFirstDayOfWeek(Calendar.MONDAY);
            /**
             * 设置一年中第一个星期所需的最少天数，例如，如果定义第一个星期包含一年第一个月的第一天，则使用值 1 调用此方法。
             * 如果最少天数必须是一整个星期，则使用值 7 调用此方法。
             **/
            c.setMinimalDaysInFirstWeek(1);
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            c.setTime(sdf.parse(str));
            return c.get(Calendar.WEEK_OF_YEAR);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 得到某年某周的第一天
     *
     * @param year
     * @param week
     * @return
     */
    public static Date getFirstDayOfWeek(int year, int week) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.WEEK_OF_YEAR, week);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);// 设置周一
        c.setFirstDayOfWeek(Calendar.MONDAY);
        return c.getTime();
    }

    /**
     * 得到某年某周的最后一天
     *
     * @param year
     * @param week
     * @return
     */
    public static Date getLastDayOfWeek(int year, int week) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.WEEK_OF_YEAR, week);
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        return c.getTime();
    }

    public static void main(String[] args) {
        System.out.println(getWeekOfYear(new Date()));
        System.out.println(getWeekOfYear("2015-12-03", "yyyy-MM-dd"));
        System.out.println(date2str(getFirstDayOfWeek(2015, 49), "yyy-MM-dd"));
        System.out.println(date2str(getLastDayOfWeek(2015, 49), "yyyy-MM-dd"));
    }

}
