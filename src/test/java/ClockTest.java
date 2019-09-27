import com.ecnu.onion.Util.TimeParser;
import com.ecnu.onion.clock.*;
import com.ecnu.onion.constant.OffsetConstant;
import com.ecnu.onion.controller.ClockController;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

/**
 * @author onion
 * @date 2019/9/25 -5:45 下午
 */

public class ClockTest {
    private ClockController controller;
    @BeforeTest
    public void beforeTest(){
        controller = ClockController.getInstance();
    }
    //测试手机时间是否设置为北京时间
    @Test
    public void testPhoneTime(){
        PhoneClock phoneClock = new PhoneClock();
        PekingClock pekingClock = new PekingClock();
        Assert.assertEquals(phoneClock.getTime(), pekingClock.getTime());
    }

    //测试每个钟时间时差是否正确
    @Test
    public void testClockTime(){
        PekingClock pekingClock = new PekingClock();
        LondonClock londonClock = new LondonClock();
        MoscowClock moscowClock = new MoscowClock();
        NewYorkClock newYorkClock = new NewYorkClock();
        SydneyClock sydneyClock = new SydneyClock();
        Assert.assertEquals(sydneyClock.getTime().getHour() - OffsetConstant.SYDNEY_OFFSET, pekingClock.getTime().getHour() + OffsetConstant.BEIJING_OFFSET);
        Assert.assertEquals(newYorkClock.getTime().getHour() - OffsetConstant.NEW_YORK_OFFSET, pekingClock.getTime().getHour() + OffsetConstant.BEIJING_OFFSET);
        Assert.assertEquals(moscowClock.getTime().getHour() - OffsetConstant.MOSCOW_OFFSET, pekingClock.getTime().getHour() + OffsetConstant.BEIJING_OFFSET);
        Assert.assertEquals(londonClock.getTime().getHour() - OffsetConstant.LONDON_OFFSET, pekingClock.getTime().getHour() + OffsetConstant.BEIJING_OFFSET);
    }

    //测试util.TimeParser能否正常工作
    @Test
    public void testTimeParser(){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String str = time.format(df);
        Assert.assertEquals(time.getHour(), TimeParser.getLocalTime(str).getHour());
        Assert.assertEquals(time.getMinute(), TimeParser.getLocalTime(str).getMinute());
        Assert.assertEquals(time.getSecond(), TimeParser.getLocalTime(str).getSecond());
        Assert.assertEquals(time.getYear(), TimeParser.getLocalTime(str).getYear());
        Assert.assertEquals(time.getMonth(), TimeParser.getLocalTime(str).getMonth());
        Assert.assertEquals(time.getDayOfMonth(), TimeParser.getLocalTime(str).getDayOfMonth());
    }

    //测试ClockController是否为单例模式
    @Test
    public void testSingleController(){
        ClockController controller2 = ClockController.getInstance();
        Assert.assertSame(controller, controller2);
    }

    //测试调整手机时间
    @Test
    public void testAdjustTime(){
        String adjustTime = "2019-09-27 15:17:30";
        controller.adjustTime(adjustTime);
        Assert.assertEquals(controller.getPhoneClock().getTime().getHour(), 15);
        Assert.assertEquals(controller.getPhoneClock().getTime().getMinute(), 17);
        Assert.assertEquals(controller.getPhoneClock().getTime().getSecond(), 30);
        Assert.assertEquals(controller.getPhoneClock().getTime().getYear(), 2019);
        Assert.assertEquals(controller.getPhoneClock().getTime().getMonthValue(), 9);
        Assert.assertEquals(controller.getPhoneClock().getTime().getDayOfMonth(), 27);
    }

    //测试调整手机时间后时钟的时间显示
    @Test
    public void testAdjustClockTime(){
        String adjustTime = "2019-09-27 15:17:30";
        controller.adjustTime(adjustTime);
        Set<Clock> clocks =  controller.getClocks();
        for (Clock clock : clocks) {
            if (clock instanceof NewYorkClock){
                Assert.assertEquals(clock.getTime().getHour(), 15 + OffsetConstant.NEW_YORK_OFFSET );
            }
            if (clock instanceof MoscowClock){
                Assert.assertEquals(clock.getTime().getHour(), 15 + OffsetConstant.MOSCOW_OFFSET );
            }
            if (clock instanceof LondonClock){
                Assert.assertEquals(clock.getTime().getHour(), 15 + OffsetConstant.LONDON_OFFSET );
            }
            if (clock instanceof SydneyClock){
                Assert.assertEquals(clock.getTime().getHour(), 15 + OffsetConstant.SYDNEY_OFFSET );
            }
            if (clock instanceof PekingClock){
                Assert.assertEquals(clock.getTime().getHour(), 15 + OffsetConstant.BEIJING_OFFSET );
            }
        }
    }
}
