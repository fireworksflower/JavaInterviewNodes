package com.hh.spring.sixthreadstates;

public class Demo01 implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Demo01());
        System.out.println(thread.getState());//NEW
        thread.start();
        System.out.println(thread.getState());//RUNNABLE
        thread.sleep(10);
        //即使是正在运行中，状态也是RUNNABLE
        System.out.println(thread.getState());//RUNNABLE
        thread.sleep(1000);
        System.out.println(thread.getState());//TERMINATED
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
