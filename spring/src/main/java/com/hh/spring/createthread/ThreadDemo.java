package com.hh.spring.createthread;

/**
 * 用继承Thread的方式实现多线程
 */
public class ThreadDemo extends Thread {

    public static void main(String[] args) {
        new ThreadDemo().start();
    }

    public void run(){
        System.out.println("用继承Thread的方式实现多线程");
    }
}
