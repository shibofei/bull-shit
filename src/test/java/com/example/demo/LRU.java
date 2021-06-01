package com.example.demo;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU<k, v> extends LinkedHashMap<k, v> {
    private static final long serialVersionUID = -3460458856446834109L;

    private int capacity;

    public LRU(int capacity) {
        super(16, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {
        return size() > this.capacity;
    }

    public static void main(String[] args) {

        int capacity = 10;
        LRU<String, String> lru = new LRU<>(capacity);

        for (int i = 0; i < capacity + 1; i++) {
            //remove the eldest key "0"
            lru.put(Integer.toString(i), Integer.toString(i));
            //if get the eldest key "0", lru will move entry <"0","0"> to the end of list
            //if (i==capacity/2) System.out.println(lru.get(Integer.toString(0)));
        }
    }
}
