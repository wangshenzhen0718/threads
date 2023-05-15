package com.wang.p1_volatile;

import java.util.concurrent.TimeUnit;

/**
 * @Author wsz
 * @Description volatile保证可见性代码证明
 * @Date 2023/5/15
 */
public class C1_MyData {

    //public  int num = 10;
    public volatile int num = 10;

    public void addTo60() {
        num = 60;
    }
}

class VolatileDemo {
    public static void main(String[] args) {
        C1_MyData myData = new C1_MyData();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "come in\n");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                myData.addTo60();

            }
        }, "AAA").start();

        while (myData.num == 10) {
        }
        System.out.println(Thread.currentThread().getName() + ":over:" + myData.num);


    }
}
