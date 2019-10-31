package com.hh.spring.starthhread;

public class StartAndRunDemo {
    public static void main(String[] args) {
        Runnable runnable =()->{
            System.out.println(Thread.currentThread().getName());
        };
        runnable.run();

        new Thread(runnable).start();
    }
}
