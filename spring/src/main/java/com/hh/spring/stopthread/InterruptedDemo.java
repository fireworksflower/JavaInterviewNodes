package com.hh.spring.stopthread;

public class InterruptedDemo implements Runnable {
    @Override
    public void run() {
        System.out.println("interrupted");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new InterruptedDemo());
        thread.start();
        thread.interrupt();
        System.out.println(thread.isInterrupted());//true
        //调用interrupted()方法，目标是当前线程main,而不管是谁调用它
        System.out.println(thread.interrupted());//false
        System.out.println(Thread.interrupted());//false
        System.out.println(thread.isInterrupted());//true
    }
}