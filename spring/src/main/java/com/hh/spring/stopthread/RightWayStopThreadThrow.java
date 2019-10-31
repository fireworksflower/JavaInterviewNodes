package com.hh.spring.stopthread;

/**
 * catch了InterruptedException之后的优先选择：在方法签名中抛出异常，在调用该方法中try/catch,
 * 可以执行自己捕获异常的逻辑
 */
public class RightWayStopThreadThrow implements Runnable{


    @Override
    public void run() {
        while (true){
            System.out.println("开始执行");
            try {
                throwMethod();
            } catch (InterruptedException e) {
                System.out.println("抛出异常了");
                e.printStackTrace();
            }
        }
    }

    private void throwMethod() throws InterruptedException {
        Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadThrow());
        thread.start();
        thread.sleep(1000);
        thread.interrupt();
    }
}
