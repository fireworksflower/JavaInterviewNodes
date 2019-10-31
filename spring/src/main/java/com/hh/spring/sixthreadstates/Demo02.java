package com.hh.spring.sixthreadstates;

public class Demo02 implements Runnable {
    public static void main(String[] args) {
        Demo02 demo02 = new Demo02();
        Thread t1 = new Thread(demo02);
        t1.start();
        Thread t2 = new Thread(demo02);
        t2.start();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t1.getState());//TIMED_WAITING

        System.out.println(t2.getState());//BLOCKED

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t1.getState());//WAITING

    }
    @Override
    public void run() {
        syn();
    }

    private synchronized  void syn() {
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
