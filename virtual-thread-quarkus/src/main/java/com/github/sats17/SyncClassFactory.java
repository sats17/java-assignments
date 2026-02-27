package com.github.sats17;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SyncClassFactory {

    private Map<Integer, SyncClass> syncClassMap = new ConcurrentHashMap<>();

    public SyncClass getSyncClass(Integer ID) {
        this.syncClassMap.putIfAbsent(ID, new SyncClass());
        return this.syncClassMap.get(ID);
    }

}
