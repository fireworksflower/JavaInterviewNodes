package com.hh.spring.stopthread;

/**
 * run()方法内没有sleep或者wait方法时，用thread.interrupt();停止线程
 */
public class RightWayStopThreadWithoutSleep implements Runnable{

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new RightWayStopThreadWithoutSleep());
        thread.start();
        thread.sleep(1000);
        thread.interrupt();

    }

    @Override
    public void run() {
        int num = 0;
        while (!Thread.currentThread().isInterrupted() && num<=Integer.MAX_VALUE / 2){
            if(num % 10000 == 0){
                System.out.println(num+ " 是10000的倍数");
            }
            num++;
        }
        System.out.println(Thread.currentThread().isInterrupted());
        System.out.println("任务运行结束了");
    }
}
