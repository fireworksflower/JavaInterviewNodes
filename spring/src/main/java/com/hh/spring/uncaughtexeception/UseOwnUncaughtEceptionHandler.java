package com.hh.spring.uncaughtexeception;

public class UseOwnUncaughtEceptionHandler implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler("捕获器"));

        new Thread(new UseOwnUncaughtEceptionHandler(),"thread-1").start();
        Thread.sleep(200);
        new Thread(new UseOwnUncaughtEceptionHandler(),"thread-2").start();
        Thread.sleep(200);

        new Thread(new UseOwnUncaughtEceptionHandler(),"thread-3").start();
        Thread.sleep(200);

        new Thread(new UseOwnUncaughtEceptionHandler(),"thread-4").start();
        Thread.sleep(200);

    }
    @Override
    public void run() {
        throw new RuntimeException();
    }
}
