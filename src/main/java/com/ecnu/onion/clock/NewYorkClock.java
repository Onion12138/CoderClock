package com.ecnu.onion.clock;

import com.ecnu.onion.constant.OffsetConstant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author onion
 * @date 2019/9/25 -6:11 下午
 */
public class NewYorkClock implements Clock{
    private LocalDateTime localDateTime;

    public NewYorkClock(){
        localDateTime = LocalDateTime.now().plusHours(OffsetConstant.NEW_YORK_OFFSET);
    }

    @Override
    public String getFormatTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "the time of New York clock is " + localDateTime.format(formatter);
    }

    @Override
    public void setTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime.plusHours(OffsetConstant.NEW_YORK_OFFSET);
    }
    @Override
    public LocalDateTime getTime() {
        return localDateTime;
    }
}
