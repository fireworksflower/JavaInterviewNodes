package com.hh.spring.waitnotifythread;

/**
 * 让两个线程轮流打印1-100之内的奇偶数
 */
public class WaitNotifyPrintOddEven{
    private static int count = 0;
    private static Object o = new Object();

    public static void main(String[] args) {
        TurningRunner turn = new TurningRunner();
        Thread t1 = new Thread(turn);
        Thread t2 = new Thread(turn);
        t1.start();
        t2.start();
    }

    static class TurningRunner implements Runnable{
        @Override
        public void run() {
            while (count<=100){
                synchronized (o){
                    System.out.println(Thread.currentThread().getName()+" : "+count++);
                    o.notify();
                    if(count<=100){
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
