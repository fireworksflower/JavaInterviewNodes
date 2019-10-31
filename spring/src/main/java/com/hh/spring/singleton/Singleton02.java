package com.hh.spring.singleton;

/**
 * 饿汉式（静态代码块）可用
 *
 */
public class Singleton02 {
    private  static Singleton02  instance ;

    static {
        instance = new Singleton02();
    }

    private Singleton02(){

    }

    public static Singleton02 getInstance(){
        return instance;
    }
}
