package com.ecnu.onion.view;

import com.ecnu.onion.controller.ClockController;

import java.util.Scanner;

/**
 * @author onion
 * @date 2019/9/25 -6:54 下午
 */
public class ClockView {
    public static void main(String[] args) {
        ClockController controller = ClockController.getInstance();
        System.out.println("********************************");
        System.out.println("***** 欢迎使用码农酒店时钟系统 *****");
        System.out.println("********************************");
        System.out.println("选择响应的操作");
        System.out.println("1：查看所有时钟时间");
        System.out.println("2：查看手机时间");
        System.out.println("3：通过手机调整时钟时间");
        System.out.println("q：推出系统");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        while (true){
            switch (option){
                case "1" :
                    controller.showAllClockTime();
                    break;
                case "2" :
                    controller.showPhoneTime();
                    break;
                case "3" :
                    System.out.println("按格式'yyyy-MM-dd HH:mm:ss'输入时间");
                    String time = scanner.nextLine();
                    try{
                        controller.adjustTime(time);
                        System.out.println("时间设置成功");
                    }catch (Exception e){
                        System.out.println("设置时间出错");
                    }
                    break;
                case "q" :
                    System.out.println("再见");
                    return;
                default :
                    System.out.println("请输入正确的选项");
                    break;
            }
            option = scanner.nextLine();
        }


    }
}
