package com.hh.spring.waitnotifythread;

/**
 *  让两个线程轮流打印1-100之内的奇偶数
 *  先执行notify()方法，再执行wait()方法
 *  如果先执行wait()方法，则没有地方notify()唤醒了
 */
public class WaitNotifyPrintOddEvenDemo02 implements Runnable{
    private static int count = 0;
    private static Object o = new Object();

    public static void main(String[] args) {
        WaitNotifyPrintOddEvenDemo02 turn = new WaitNotifyPrintOddEvenDemo02();
        Thread t1 = new Thread(turn);
        Thread t2 = new Thread(turn);
        t1.start();
        t2.start();
    }

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
