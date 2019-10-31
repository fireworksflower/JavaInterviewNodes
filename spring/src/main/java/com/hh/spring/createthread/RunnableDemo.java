package com.hh.spring.createthread;

/**
 * 用实现Runnable接口的方式实现多线程
 */
public class RunnableDemo implements Runnable {
    public static void main(String[] args) {

        new Thread(new RunnableDemo()).start();
    }

    @Override
    public void run() {
        System.out.println("用实现Runnable接口的实现多线程");
    }
}
