package com.hh.spring.singleton;

/**
 * 懒汉式（线程不安全）【不可用】
 *
 */
public class Singleton03 {
    private  static Singleton03 instance ;

    private Singleton03(){

    }

    public static Singleton03 getInstance(){
        if(null ==instance){
            instance = new Singleton03();
        }
        return instance;
    }
}
