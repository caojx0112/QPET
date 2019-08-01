package com.qf.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ** 程序猿
 * 一入代码深似海，
 * 小试牛刀异常来。
 * 奈何BUG直挠耳，
 * 仰天大笑出门来。
 */
public class DateFormat {
    public static String format(Date date) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = sf.format(date);
        return format;
    }
}
