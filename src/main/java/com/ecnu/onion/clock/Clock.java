package com.ecnu.onion.clock;

import java.time.LocalDateTime;

/**
 * @author onion
 * @date 2019/9/25 -6:13 下午
 */
public interface Clock {
    String getFormatTime();
    void setTime(LocalDateTime localDateTime);
    LocalDateTime getTime();
}
