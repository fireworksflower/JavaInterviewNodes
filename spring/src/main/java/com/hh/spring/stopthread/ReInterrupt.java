package com.hh.spring.stopthread;

/**
 *
 * 在catch子语句中调用Thread.currentThread().interrupt()可以恢复中断状态
 */
public class ReInterrupt implements Runnable{

    @Override
    public void run() {
        while (true){
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Interrupted,终止程序，程序结束");
                System.out.println("hahaha");
                break;
            }
            System.out.println("aa");
            reInterrupt();

        }
    }

    private void reInterrupt() {
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println("进入catch");
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ReInterrupt());
        thread.start();
        thread.sleep(1000);
        //thread.interrupt();

    }
}
