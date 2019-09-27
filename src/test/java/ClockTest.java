import com.ecnu.onion.Util.TimeParser;
import com.ecnu.onion.clock.*;
import com.ecnu.onion.constant.OffsetConstant;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

/**
 * @author onion
 * @date 2019/9/25 -5:45 下午
 */

public class ClockTest {
    @Test
    public void testPhoneTime(){
        PhoneClock phoneClock = new PhoneClock();
        PekingClock pekingClock = new PekingClock();
        Assert.assertEquals(phoneClock.getTime(), pekingClock.getTime());
    }

    @Test
    public void testClockTime(){
        PekingClock pekingClock = new PekingClock();
        LondonClock londonClock = new LondonClock();
        MoscowClock moscowClock = new MoscowClock();
        NewYorkClock newYorkClock = new NewYorkClock();
        SydneyClock sydneyClock = new SydneyClock();
        Assert.assertEquals(sydneyClock.getTime().minusHours(OffsetConstant.SYDNEY_OFFSET), pekingClock.getTime().minusHours(OffsetConstant.BEIJING_OFFSET));
        Assert.assertEquals(newYorkClock.getTime().minusHours(OffsetConstant.NEW_YORK_OFFSET), pekingClock.getTime().minusHours(OffsetConstant.BEIJING_OFFSET));
        Assert.assertEquals(moscowClock.getTime().minusHours(OffsetConstant.MOSCOW_OFFSET), pekingClock.getTime().minusHours(OffsetConstant.BEIJING_OFFSET));
        Assert.assertEquals(londonClock.getTime().minusHours(OffsetConstant.LONDON_OFFSET), pekingClock.getTime().minusHours(OffsetConstant.BEIJING_OFFSET));
    }

    @Test
    public void testTimeParser(){
        LocalDateTime time = LocalDateTime.now();
        String str = time.toString();
        Assert.assertEquals(time, TimeParser.getLocalTime(str));
    }
    
}
