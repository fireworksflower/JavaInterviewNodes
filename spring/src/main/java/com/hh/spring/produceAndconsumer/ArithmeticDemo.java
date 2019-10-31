package com.hh.spring.produceAndconsumer;

import java.util.concurrent.ThreadPoolExecutor;

public class ArithmeticDemo implements Runnable{

    private Long l = 10L;

    public static void main(String[] args) {
        ArithmeticDemo arithmeticDemo = new ArithmeticDemo();




    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
    class TwoArithmetic implements Runnable{
        private A a;

        public TwoArithmetic(A a) {
            this.a = a;
        }

        @Override
        public void run() {

        }
    }

    class OneArithmetic{

    }

    class A{
        private Integer l = 10;

        public A(Integer l) {
            this.l = l;
        }
    }
}
