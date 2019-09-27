package com.ecnu.onion.controller;

import com.ecnu.onion.Util.TimeParser;
import com.ecnu.onion.clock.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author onion
 * @date 2019/9/25 -6:05 下午
 */
public class ClockController {
    private static ClockController instance;
    private PhoneClock phoneClock = new PhoneClock();
    private Set<Clock> clocks;

    public PhoneClock getPhoneClock() {
        return phoneClock;
    }

    public Set<Clock> getClocks() {
        return clocks;
    }

    private ClockController(){
        clocks = new HashSet<>();
        clocks.add(new LondonClock());
        clocks.add(new MoscowClock());
        clocks.add(new NewYorkClock());
        clocks.add(new PekingClock());
        clocks.add(new SydneyClock());
    }
    public static ClockController getInstance(){
        if (instance == null)
            instance = new ClockController();
        return instance;
    }

    public void adjustTime(String time){
        LocalDateTime localTime = TimeParser.getLocalTime(time);
        phoneClock.setTime(localTime);
        for (Clock clock : clocks) {
            clock.setTime(localTime);
        }
    }
    public void showPhoneTime(){
        System.out.println(phoneClock.getFormatTime());
    }
    public void showAllClockTime(){
        for (Clock clock : clocks) {
            System.out.println(clock.getFormatTime());
        }
    }

}
