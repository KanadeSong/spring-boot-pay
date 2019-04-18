package com.ljj.pay.common.utils;

import org.apache.commons.lang.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @CLassName DateUtil
 * @Description 日期操作类
 * @Author LeeJack
 * @Date 2019/4/18/018 20:51
 * @Version 1.0
 */
public class DateUtil {
    private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

    private final static SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");

    private final static SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");

    private final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     *
     * @Description: 获取YYYY格式
     * @Param []
     * @return java.lang.String
     * @author LeeJack
     * @Date 20:52 2019/4/18/018
     */
    public static String getYear() {
        return sdfYear.format(new Date());
    }

    Timestamp timestamp = new Timestamp(new Date().getTime());

    /**
     *
     * @Description: 获取YYYY-MM-DD格式
     * @Param []
     * @return java.lang.String
     * @author LeeJack
     * @Date 20:52 2019/4/18/018
     */
    public static String getDay() {
        return sdfDay.format(new Date());
    }

    /**
     *
     * @Description: 获取YYYYMMDD格式
     * @Param []
     * @return java.lang.String
     * @author LeeJack
     * @Date 20:52 2019/4/18/018
     */
    public static String getDays() {
        return sdfDays.format(new Date());
    }

    /**
     *
     * @Description: 获取YYYY-MM-DD hh:mm:ss格式
     * @Param []
     * @return java.lang.String
     * @author LeeJack
     * @Date 20:52 2019/4/18/018
     */
    public static String getTime() {
        return sdfTime.format(new Date());
    }

    /**
     *
     * @Description: (日期比较，如果s>=e 返回true 否则返回false)
     * @Param [s, e]
     * @return boolean
     * @author LeeJack
     * @Date 20:53 2019/4/18/018
     */
    public static boolean compareDate(String s, String e) {
        if (fomatDate(s) == null || fomatDate(e) == null) {
            return false;
        }
        return fomatDate(s).getTime() >= fomatDate(e).getTime();
    }

    /**
     *
     * @Description: 格式化日期
     * @Param [date]
     * @return java.util.Date
     * @author LeeJack
     * @Date 20:53 2019/4/18/018
     */
    public static Date fomatDate(String date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return fmt.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @Description: 校验日期是否合法
     * @Param [s]
     * @return boolean
     * @author LeeJack
     * @Date 20:53 2019/4/18/018
     */
    public static boolean isValidDate(String s) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fmt.parse(s);
            return true;
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }
    }

    public static int getDiffYear(String startTime, String endTime) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / (1000 * 60 * 60 * 24)) / 365);
            return years;
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return 0;
        }
    }

    /**
     *
     * @Description: 功能描述：时间相减得到天数
     * @Param [beginDateStr, endDateStr]
     * @return long
     * @author LeeJack
     * @Date 20:53 2019/4/18/018
     */
    public static long getDaySub(String beginDateStr, String endDateStr) {
        long day = 0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date beginDate = null;
        java.util.Date endDate = null;

        try {
            beginDate = format.parse(beginDateStr);
            endDate = format.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
        // System.out.println("相隔的天数="+day);

        return day;
    }

    /**
     *
     * @Description: 得到n天之后的日期
     * @Param [days]
     * @return java.lang.String
     * @author LeeJack
     * @Date 20:53 2019/4/18/018
     */
    public static String getAfterDayDate(String days) {
        int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdfd.format(date);

        return dateStr;
    }
    /**
     *
     * @Description: 得到n天之前的日期
     * @Param [days]
     * @return java.lang.String
     * @author LeeJack
     * @Date 20:53 2019/4/18/018
     */
    public static String getBeforeDayDate(String days) {
        int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        String dateStr = sdfDays.format(date);

        return dateStr;
    }

    /**
     *
     * @Description: 得到n天之后是周几
     * @Param [days]
     * @return java.lang.String
     * @author LeeJack
     * @Date 20:54 2019/4/18/018
     */
    public static String getAfterDayWeek(String days) {
        int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("E");
        String dateStr = sdf.format(date);

        return dateStr;
    }

    /**
     *
     * @Description: 按照yyyy-MM-dd HH:mm:ss的格式，日期转字符串
     * @Param [date]
     * @return java.lang.String
     * @author LeeJack
     * @Date 20:54 2019/4/18/018
     */
    public static String date2Str(Date date) {
        return date2Str(date, "yyyy-MM-dd");
    }

    /**
     *
     * @Description: 按照yyyy-MM-dd HH:mm:ss的格式，字符串转日期
     * @Param [date]
     * @return java.util.Date
     * @author LeeJack
     * @Date 20:54 2019/4/18/018
     */
    public static Date str2Date(String date) {
        if (StringUtils.isNotBlank(date)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                return sdf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Date();
        } else {
            return null;
        }
    }

    /**
     *
     * @Description: 按照参数format的格式，日期转字符串
     * @Param [date, format]
     * @return java.lang.String
     * @author LeeJack
     * @Date 20:54 2019/4/18/018
     */
    public static String date2Str(Date date, String format) {
        if (null == format) {
            format = "yyyy-MM-dd";
        }
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        } else {
            return "";
        }
    }

    /**
     *
     * @Description: 把时间根据时、分、秒转换为时间段
     * @Param [StrDate]
     * @return java.lang.String
     * @author LeeJack
     * @Date 20:58 2019/4/18/018
     */
    public static String getTimes(String StrDate) {
        String resultTimes = "";

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date now;

        try {
            now = new Date();
            java.util.Date date = df.parse(StrDate);
            long times = now.getTime() - date.getTime();
            long day = times / (24 * 60 * 60 * 1000);
            long hour = (times / (60 * 60 * 1000) - day * 24);
            long min = ((times / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long sec = (times / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);

            StringBuffer sb = new StringBuffer();
            // sb.append("发表于：");
            if (hour > 0) {
                sb.append(hour + "小时前");
            } else if (min > 0) {
                sb.append(min + "分钟前");
            } else {
                sb.append(sec + "秒前");
            }

            resultTimes = sb.toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return resultTimes;
    }

    public static String getTimestamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }
}
