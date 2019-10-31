package com.hh.spring.stopthread;

/**
 * 如果在执行过程中，每次循环都会调用sleep或wait等方法，那么不需要每次迭代都检查是否已中断
 *
 * 其实JVM在执行代码是非常快的，耗时都在sleep()的时候
 */
public class RightWayStopThreadWithSleepEveryLoop {


    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            int num = 0;
            try {
                while (num <500 ){
                    if(num %100 ==0){
                        System.out.println(num +"是100的倍数");
                    }
                    num++;
                    Thread.sleep(10);
                }

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
