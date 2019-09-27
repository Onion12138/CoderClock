package com.ecnu.onion.clock;

import com.ecnu.onion.constant.OffsetConstant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author onion
 * @date 2019/9/25 -6:11 下午
 */
public class MoscowClock implements Clock {
    private LocalDateTime localDateTime;

    public MoscowClock(){
        localDateTime = LocalDateTime.now().plusHours(OffsetConstant.MOSCOW_OFFSET);
    }

    @Override
    public String getFormatTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "the time of Moscow clock is " + localDateTime.format(formatter);
    }

    @Override
    public void setTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime.plusHours(OffsetConstant.MOSCOW_OFFSET);
    }
    @Override
    public LocalDateTime getTime() {
        return localDateTime;
    }
}
