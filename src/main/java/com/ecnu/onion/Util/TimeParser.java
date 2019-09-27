package com.ecnu.onion.Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author onion
 * @date 2019/9/25 -6:18 下午
 */
public class TimeParser {
    public static LocalDateTime getLocalTime(String time){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(time, df);
        return localDateTime;
    }
    public static void main(String[] args) {
        String time = "2019-9-25 11:20";
        System.out.println(getLocalTime(time));
    }
}
