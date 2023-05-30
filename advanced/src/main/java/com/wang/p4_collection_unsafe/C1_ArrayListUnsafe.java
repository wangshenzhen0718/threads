package com.wang.p4_collection_unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class C1_ArrayListUnsafe {
    public static void main(String[] args) {
        //有线程安全问题 在打印之前modCount被修改后发生了变化
        //List<String> list = new ArrayList<>();
        //解决方法之一
        //List<String> list = new Vector<>();
        //解决方法之二
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        //解决方法之三
        List<String> list = new CopyOnWriteArrayList();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
