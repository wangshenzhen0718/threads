package com.wang.p4_collection_unsafe;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class C2_SetUnSafe {
    public static void main(String[] args) {
        //有线程安全问题 在打印之前modCount被修改后发生了变化
        //Set<String> set=new HashSet();
        //解决方法之一
        //Set<String> set= Collections.synchronizedSet(new HashSet<>());
        //解决方法之二
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}
