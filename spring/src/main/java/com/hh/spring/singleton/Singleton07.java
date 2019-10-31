package com.hh.spring.singleton;

/**
 * 静态内部类【推荐用】
 *
 */
public class Singleton07 {
    private Singleton07(){

    }

    private static class SingletonInstance{
        private  static Singleton07 instance  = new Singleton07();

    }

    public static Singleton07 getInstance() {
       return SingletonInstance.instance;
    }
}
