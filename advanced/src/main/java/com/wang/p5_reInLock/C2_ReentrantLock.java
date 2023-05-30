package com.wang.p5_reInLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class C2_ReentrantLock implements Runnable{
    Lock lock = new ReentrantLock();

    public void setLock() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t setLock");
        }finally {
            lock.unlock();
        }
    }

    public void getLock() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t getLock");
            setLock();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        getLock();
    }
}

class TestC2{
    public static void main(String[] args) {
        C2_ReentrantLock c2_reentrantLock = new C2_ReentrantLock();
        Thread thread1 = new Thread(c2_reentrantLock,"t1");
        Thread thread2 = new Thread(c2_reentrantLock,"t2");
        thread1.start();
        thread2.start();
    }

}
