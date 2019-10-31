package com.hh.spring.singleton;

/**
 * 懒汉式（线程安全,同步方法）【不推荐用】
 *
 */
public class Singleton04 {
    private  static Singleton04 instance ;

    private Singleton04(){

    }

    public static synchronized Singleton04 getInstance(){
        if(null ==instance){
            instance = new Singleton04();
        }
        return instance;
    }
}
