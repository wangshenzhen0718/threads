package com.wang.p2_cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author wsz
 * @Description cas
 * @Date 2023/5/25
 */
public class C1_CasDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t" + "当前值" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2014) + "\t" + "当前值" + atomicInteger.get());
    }
}
