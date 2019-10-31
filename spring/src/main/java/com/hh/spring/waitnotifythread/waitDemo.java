package com.hh.spring.waitnotifythread;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.locks.ReentrantLock;

public class waitDemo  {
    private static Object o = new Object();

    static class Thread1 extends Thread{
        public void run(){
            synchronized (o){
                System.out.println(Thread.currentThread().getName()+"开始执行了");

            try {
                o.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"获取到了锁");
            }
        }
    }
    static class Thread2 extends Thread{
        public void run(){
            synchronized (o){
                o.notify();
                System.out.println(Thread.currentThread().getName()+"调用了notify()方法");
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        new Thread1().start();
        Thread.sleep(200);
        new Thread2().start();
    }

}
