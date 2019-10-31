package com.hh.spring.starthhread;

/**
 *一个线程中不能调用两次start()方法
 */
public class CannotStartTwice {

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start();
    }
}
