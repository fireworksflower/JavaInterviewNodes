package com.hh.spring.stopthread;

/**
 * 如果while里面有被try catch包裹着的sleep()方法，则中断不了线程
 * 原因是sleep一旦抛出sleep interrupted异常后，会把中断状态恢复
 */
public class CannotInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
                while (num <500 && !Thread.currentThread().isInterrupted()){
                    if(num %100 ==0){
                        System.out.println(num +"是100的倍数");
                    }
                    num++;
                    try {
                        Thread.sleep(10);
                    } catch (Exception e){
                            e.printStackTrace();
                        }
                }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        thread.sleep(1);
        thread.interrupt();
        /*thread.sleep(4000);
        thread.interrupt();*/

    }
}
