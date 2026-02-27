package com.github.sats17;

public class SyncClass {

    private Integer counter;

    public SyncClass() {
        counter = 0;
    }

    public synchronized Integer increase()  {
        System.out.println("Increasing count for "+Thread.currentThread().getName());
        counter++;
        return this.counter;
    }

    public Integer getCounter(){
        return this.counter;
    }

}
