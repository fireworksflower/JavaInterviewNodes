package com.hh.spring.uncaughtexeception;

public class CannotCatch implements Runnable{
    public static void main(String[] args) {
        new Thread(new CannotCatch(),"thread-1").start();
        new Thread(new CannotCatch(),"thread-2").start();
        new Thread(new CannotCatch(),"thread-3").start();
        new Thread(new CannotCatch(),"thread-4").start();
    }
    @Override
    public void run() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("Caught Exception");
            e.printStackTrace();
        }
    }
}
