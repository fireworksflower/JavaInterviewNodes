package com.hh.spring.singleton;

/**
 * 懒汉式（双重检查）【推荐用】
 *
 */
public class Singleton06 {
    private  static Singleton06 instance ;

    private Singleton06(){

    }

    public static Singleton06 getInstance(){
        if(null ==instance){
            synchronized (Singleton06.class){
                if(instance ==null){
                    instance = new Singleton06();
                }
            }
        }
        return instance;
    }
}
