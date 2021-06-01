package com.example.demo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRU_Manual<k, v> {
    public LRU_Manual(int capacity){
        this.capacity = capacity;
    }
    private int capacity;
    private Map<k,v> map = new HashMap<>();
    private LinkedList<k> list = new LinkedList<>();

    public v get(k key){
        v value = map.get(key);
        if(value==null) return null;
        list.remove(key);
        list.addFirst(key);
        return value;
    }

    public void put(k key,v value){
        map.put(key,value);
        list.remove(key);
        list.addFirst(key);
        if(list.size()>capacity) {
            expire();
        }
    }

    private void expire(){
        k key = list.getLast();
        map.remove(key);
        list.removeLast();
    }

    public static void main(String[] args) {
        LRU<Integer, Integer> lru = new LRU<>(5);
        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        System.out.println(lru.get(1));
        lru.put(4,4);
        lru.put(5,5);
        lru.put(6,6);
        System.out.println(lru.get(3));

    }
}
