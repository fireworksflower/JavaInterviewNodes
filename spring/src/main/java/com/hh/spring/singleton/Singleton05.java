package com.hh.spring.singleton;

/**
 * 懒汉式（线程安全,同步代码块）【不可用】
 *
 */
public class Singleton05 {
    private  static Singleton05 instance ;

    private Singleton05(){

    }

    public static  Singleton05 getInstance(){
        if(null ==instance){
            synchronized (Singleton05.class){
                instance = new Singleton05();
            }
        }
        return instance;
    }
}
