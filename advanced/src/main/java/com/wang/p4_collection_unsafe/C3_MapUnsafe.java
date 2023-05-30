package com.wang.p4_collection_unsafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class C3_MapUnsafe {
    public static void main(String[] args) {

        //Map<String,String> map = new HashMap<>();
        //解决方法之一
        //Map<String,String> map = new ConcurrentHashMap<>();
        //解决方法之二
        Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), (UUID.randomUUID().toString().substring(0, 8)));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }
}
