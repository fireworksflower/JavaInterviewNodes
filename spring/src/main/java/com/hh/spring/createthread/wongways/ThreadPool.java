package com.hh.spring.createthread.wongways;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 用线程池的方式创建线程，其实质还是创建Thread
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Task() {
            });
        }
    }


}
class Task implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
