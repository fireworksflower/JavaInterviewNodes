package com.hh.spring.stopthread;

/**
 * 带有sleep()方法的中断线程的写法，抛出异常 java.lang.InterruptedException: sleep interrupted
 */
public class RightWayStopThreadWithSleep {


    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            int num = 0;
            try {
                while (num <500 && !Thread.currentThread().isInterrupted()){
                    if(num %100 ==0){
                        System.out.println(num +"是100的倍数");
                    }
                    num++;
                }
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        thread.sleep(1);
        thread.interrupt();
    }
}
