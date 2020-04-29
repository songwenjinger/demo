package com.example.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: SongWenjing
 * @Date 2020/4/21 22:07
 */
public class DateParse {
    //string类型转换为date类型
    public static Date parseDate(String string) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(string);
    }

    public static String dateFormate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
