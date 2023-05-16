package com.wang.p1_volatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author wsz
 * @Description volatile不保证原子性代码
 * @Date 2023/5/16
 */
public class C2_MyData {

    volatile int i = 0;
    AtomicInteger atomicInteger = new AtomicInteger();

    //演示不保证原子性代码
    public void add() {
        i++;
    }

    //演示解决原子性方法
    public void addAtom() {
        atomicInteger.getAndIncrement();
    }


}

class VolatileAtomDemo {

    public static void main(String[] args) {
        C2_MyData c2_myData = new C2_MyData();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 1000; i1++) {
                    c2_myData.addAtom();
                }

            }, String.valueOf(i)).start();
        }
        // 需要等待上面20个线程都计算完成后，在用main线程取得最终的结果值
        // 这里判断线程数是否大于2，为什么是2？因为默认是有两个线程的，一个main线程，一个gc线程
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(c2_myData.atomicInteger);

    }

}
