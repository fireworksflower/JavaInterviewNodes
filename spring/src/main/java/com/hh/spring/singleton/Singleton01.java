package com.hh.spring.singleton;

/**
 * 饿汉式（静态常量）可用
 *
 */
public class Singleton01 {
    private  static Singleton01  instance = new Singleton01();

    private Singleton01(){

    }

    public static Singleton01 getInstance(){
        return instance;
    }
}
