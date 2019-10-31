package com.hh.spring.produceAndconsumer;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ProduceAndConsumer {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);
        new Thread(producer).start();
        new Thread(consumer).start();
    }


}

class Producer implements Runnable{
    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.put();

        }
    }
}
class Consumer implements Runnable{

    private Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.take();

        }
    }
}

class Storage{

    private Integer max;

    private LinkedList<Date>  storageList;

    public  Storage() {
        max = 10;
        storageList = new LinkedList<>();
    }

    public synchronized void put(){
        if(storageList.size() ==max){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storageList.add(new Date());
        System.out.println("我刚刚生产了产品，现在仓库有"+storageList.size()+"个");
        notify();
    }

    public synchronized void take(){
        if(storageList.size() ==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storageList.poll();
        System.out.println("我刚刚消费了，现在仓库还剩"+storageList.size()+"个");
        notify();
    }



}