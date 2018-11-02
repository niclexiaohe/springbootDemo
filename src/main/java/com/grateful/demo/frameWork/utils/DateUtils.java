package com.grateful.demo.frameWork.utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期时间工具类
 */
public class DateUtils {

    public final static String DEFAULT_TIMEZONE = "GMT+8";

    public final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    public final static String DEFAULT_TIME_FORMAT = "HH:mm:ss";

    public final static String SHORT_TIME_FORMAT = "yyyy-MM-dd HH:mm";

    public final static String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public final static String DEFAULT_DATETIME_SEC_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

    public final static String ISO_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";

    public final static String ISO_SHORT_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    public final static String FULL_SEQ_FORMAT = "yyyyMMddHHmmssSSS";

    public final static String FORMAT_YYYY = "yyyy";

    public final static String FORMAT_YYYYMM = "yyyyMM";

    public final static String FORMAT_YYYYMMDD = "yyyyMMdd";

    public final static String FORMAT_YYYYMMDDHH = "yyyyMMddHH";

    public final static String[] MULTI_FORMAT = {
            DEFAULT_DATE_FORMAT,
            DEFAULT_DATETIME_FORMAT,
            ISO_DATE_TIME_FORMAT,
            ISO_SHORT_DATE_TIME_FORMAT,
            SHORT_TIME_FORMAT,
            "yyyy-MM"
    };


    /**
     * Date对象转指定格式format字符串
     *
     * @param date   日期字符串
     * @param format 格式字符串
     * @return String 字符串
     */
    public static String formatDateTimeToString(Date date, String format) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * Date对象转日期字符串
     * 默认格式: {DEFAULT_DATE_FORMAT}
     *
     * @param date 日期对象
     * @return 返回"yyyy-MM-dd"日期字符串
     */
    public static String formatDate(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(date);
    }

    /**
     * Date对象转日期时间字符串
     * 默认格式: {DEFAULT_DATETIME_FORMAT}
     *
     * @param date 日期对象
     * @return 返回"yyyy-MM-dd HH:mm:ss"日期字符串
     */
    public static String formatDateTime(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(DEFAULT_DATETIME_FORMAT).format(date);
    }

    /**
     * 将日期时间对象转化为日期字符串
     * 默认格式: {SHORT_TIME_FORMAT}
     *
     * @param date 日期对象
     * @return 返回"yyyy-MM-dd HH:mm"日期字符串
     */
    public static String formatShortTime(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(SHORT_TIME_FORMAT).format(date);
    }

    /**
     * 获取当前时间的"yyyy-MM-dd HH:mm:ss.SSS"格式字符串，主要用于打印日志
     * 默认格式: {DEFAULT_DATETIME_SEC_FORMAT}
     *
     * @return 返回"yyyy-MM-dd HH:mm:ss.SSS"日期字符串
     */
    public static String getCurTimeString() {
        SimpleDateFormat sfd = new SimpleDateFormat(DEFAULT_DATETIME_SEC_FORMAT);
        return sfd.format(new Date());
    }

    /**
     * 获取当前日期时间
     *
     * @return 返回当前日期时间
     */
    public static Date getCurrentDateTime() {
        return new Date();
    }

    /**
     * 获取当前日期
     *
     * @return 返回当前日期
     */
    public static Date getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        //获取年份
        int year = calendar.get(Calendar.YEAR);
        //获取月份
        int month = calendar.get(Calendar.MONTH);
        //获取日
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 生成批处理号
     * @return 返回"PyyyyMMddHHmmssSSS"日期字符串
     */
    public static String generatePatchNoString(){
        String patchNoString;
        Date dt = new Date();
        SimpleDateFormat sfd = new SimpleDateFormat(FULL_SEQ_FORMAT);
        patchNoString = "P"+sfd.format(dt);
        return patchNoString;
    }

    /**
     * 将日期时间对象转化为日期数字
     *
     * @param date   日期字符串
     * @param format 格式字符串
     * @return 返回日期数字
     */
    public static Integer formatDateToInt(Date date, String format) {
        if (date == null) {
            return null;
        }
        return Integer.valueOf(new SimpleDateFormat(format).format(date));
    }

    /**
     * 将日期时间对象转化为日期数字
     *
     * @param date   日期字符串
     * @param format 格式字符串
     * @return 返回日期数字
     */
    public static Long formatDateToLong(Date date, String format) {
        if (date == null) {
            return null;
        }
        return Long.valueOf(new SimpleDateFormat(format).format(date));
    }



    /**
     * 将日期时间字符串---->>日期对象
     *
     * @param date   日期字符串
     * @param format 格式串
     * @return 返回日期对象
     */
    public static Date parseDate(String date, String format) {
        if (date == null) {
            return null;
        }
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 将日期时间字符串--->>日期对象
     *
     * @param date 日期字符串 {DEFAULT_DATE_FORMAT}
     * @return 返回日期对象
     */
    public static Date parseDate(String date) {
        return parseDate(date, DEFAULT_DATE_FORMAT);
    }

    /**
     * 将日期时间字符串--->>日期对象
     *
     * @param date 日期字符串 {DEFAULT_DATETIME_FORMAT}
     * @return 返回日期对象
     */
    public static Date parseDateTime(String date) {
        return parseDate(date, DEFAULT_DATETIME_FORMAT);
    }

    /**
     * 对差异时间的格式化显示，方便人工查看
     *
     * @param diffMillis 差异时间(毫秒)
     * @return 人能看懂的字符串
     */
    public static String getHumanDisplayForTimediff(Long diffMillis) {
        if (diffMillis == null) {
            return "";
        }
        long day = diffMillis / (24 * 60 * 60 * 1000);
        long hour = (diffMillis / (60 * 60 * 1000) - day * 24);
        long min = ((diffMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long se = (diffMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        StringBuilder sb = new StringBuilder();
        if (day > 0) {
            sb.append(day).append("D");
        }
        DecimalFormat df = new DecimalFormat("00");
        sb.append(df.format(hour)).append(":");
        sb.append(df.format(min)).append(":");
        sb.append(df.format(se));
        return sb.toString();
    }

    /**
     * 获取日期相差天数
     *
     * @param beginDate 字符串类型开始日期
     * @param endDate   字符串类型结束日期
     * @return Long 日期相差天数
     */
    public static Long getDiffDay(String beginDate, String endDate) {
        SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        Long checkday = 0L;
        //开始结束相差天数
        try {
            checkday = (formatter.parse(endDate).getTime() - formatter.parse(beginDate).getTime()) / (1000 * 24 * 60 * 60);
        } catch (ParseException e) {
            e.printStackTrace();
            checkday = null;
        }
        return checkday;
    }

    /**
     * 获取日期相差天数
     *
     * @param beginDate Date类型开始日期
     * @param endDate   Date类型结束日期
     * @return Long 相差天数
     */
    public static Long getDiffDay(Date beginDate, Date endDate) {
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        String strBeginDate = format.format(beginDate);

        String strEndDate = format.format(endDate);
        return getDiffDay(strBeginDate, strEndDate);
    }

    /**
     * N天之后
     *
     * @param n    天数
     * @param date 日期
     * @return n天之后
     */
    public static Date nDaysAfter(Integer n, Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + n);
        return cal.getTime();
    }

    /**
     * N天之前
     *
     * @param n    天数
     * @param date 日期
     * @return N天之后
     */
    public static Date nDaysAgo(Integer n, Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - n);
        return cal.getTime();
    }

    /**
     * 指定日期在全年中的第几周
     *
     * @param date 日期
     * @return 返回日期在这一年中的周数
     */
    public static Integer getWeekOfYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return Integer.valueOf(formatDateTimeToString(date, FORMAT_YYYY) + c.get(Calendar.WEEK_OF_YEAR));
    }


    /**
     * 日期格式化为年月日的日期
     *
     * @param date 日期
     * @return 年月日的日期
     */
    public static Date formatDate2Date(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime());
        //获取年份
        int year = calendar.get(Calendar.YEAR);
        //获取月份
        int month = calendar.get(Calendar.MONTH);
        //获取日
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }


    /**
     * 获得指定日期的前一天
     *
     * @param specifiedDay
     * @return
     * @throws Exception
     */
    public static String getSpecifiedDayBefore(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);

        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayBefore;
    }

    /**
     * 获得指定日期的后一天
     *
     * @param specifiedDay
     * @return
     */
    public static String getSpecifiedDayAfter(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + 1);

        String dayAfter = new SimpleDateFormat("yyyy-MM-dd")
                .format(c.getTime());
        return dayAfter;
    }




    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println(formatDateTimeToString(c.getTime(), FORMAT_YYYYMMDD));
        System.out.println(formatDateTimeToString(c.getTime(), FULL_SEQ_FORMAT));

        System.out.println(formatDate2Date(c.getTime()));

        Date date = getCurrentDate();
        System.out.println(date);
        System.out.println(formatDateTimeToString(date, ISO_DATE_TIME_FORMAT));
        date = getCurrentDateTime();
        System.out.println(date);
        System.out.println(formatDateTimeToString(date, ISO_DATE_TIME_FORMAT));
    }
}
