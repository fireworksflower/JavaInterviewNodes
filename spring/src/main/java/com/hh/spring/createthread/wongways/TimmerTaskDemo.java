package com.hh.spring.createthread.wongways;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 用定时器的方式实现线程
 */
public class TimmerTaskDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },1000,1000);
    }
}
