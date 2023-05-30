package com.wang.p5_reInLock;

/**
 * @Author wsz
 * @Description 也即是说，线程可以进入任何一个它已经拥有的锁所同步着的代码块。
 * @Date 2023/5/30
 */
public class C1_Demo {
    public synchronized void sendSms() {
        System.out.println(Thread.currentThread().getName() + "\t invoke sendSms");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getName() + "\t invoke sendEmail");
    }


}

class Test {
    public static void main(String[] args) {
        C1_Demo c1_demo = new C1_Demo();
        new Thread(() -> {
            c1_demo.sendSms();
        }, "t1").start();

        new Thread(() -> {
            c1_demo.sendSms();
        }, "t2").start();
    }
}