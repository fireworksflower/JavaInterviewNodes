package com.hh.spring.publishescape;


import java.util.HashMap;
import java.util.Map;

/**
 * 逸出 ：在构造函数里设置值 ，还没有完全初始化完毕就将对象暴露给外面使用
 * 解决方案：返回副本
 */
public class Demo01 {
    private Map<String,Object> states;

    private static Object object = new Object();

    public Demo01() {
        states = new HashMap<>();
        states.put("1","aa");
        states.put("2","bb");
        states.put("3","cc");
        states.put("4","dd");
    }

    public Map<String, Object> getStates() {
        return states;
    }

    public Map<String, Object> getStatesImproved() {
        return new HashMap<>(states);//创建副本
    }

    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        System.out.println(demo01.getStates().get(1));//null
        System.out.println(demo01.getStates().get(2));//null
        System.out.println(demo01.getStatesImproved().remove("1"));//删除
        System.out.println(demo01.getStatesImproved().get("1"));//aa
        System.out.println(demo01.getStatesImproved().get("2"));//bb
    }
}
