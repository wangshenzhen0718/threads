package com.wang.p6_spinlock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author wsz
 * @Description 自旋锁代码验证
 * @Date 2023/5/30
 */
public class C1_SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<Thread>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t come in!");
        while (!atomicReference.compareAndSet(null, thread)) {
            System.out.println(Thread.currentThread().getName() + "\t 正在等待");
        }
    }

    public void myUnLock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + "\t invoked myUnlock()");

    }

    public static void main(String[] args) {
        C1_SpinLockDemo spinLockDemo = new C1_SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.myLock();
            try {
                Thread.sleep(5000);
                spinLockDemo.myUnLock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t1").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(() -> {
            spinLockDemo.myLock();
            spinLockDemo.myUnLock();

        }, "t2").start();
    }
}
