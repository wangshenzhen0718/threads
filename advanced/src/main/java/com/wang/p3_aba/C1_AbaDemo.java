package com.wang.p3_aba;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author wsz
 * @Description ABA问题演示
 * @Date 2023/5/25
 */
public class C1_AbaDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t" + "当前值" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(2019, 5) + "\t" + "当前值" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 888) + "\t" + "当前值" + atomicInteger.get());
    }
}
