package com.wang.p8_syncthread;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * @Author wsz
 * @Description 当一个或多个线程调用await()时，调用线程会被阻塞。其它线程调用countDown()会将计数器减1(调用countDown方法的线程不会阻塞)，当计数器的值变为零时，因调用await方法被阻塞的线程会被唤醒，继续执行。
 * 场景：假设一个自习室里有7个人，其中有一个是班长，班长的主要职责就是在其它6个同学走了后，关灯，锁教室门，然后走人，因此班长是需要最后一个走的，那么有什么方法能够控制班长这个线程是最后一个执行，而其它线程是随机执行的
 * @Date 2023/5/31
 */
public class C1_CountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        IntStream.range(0, 6).forEach(v -> new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "离开");
            countDownLatch.countDown();
        }, String.valueOf(v)).start());
        countDownLatch.await();
        System.out.println("我最后离开");

    }
}
