package com.wang.interrupt05;

/**
 * @Author:wsz
 * @Date: 2023/1/2 21:40
 * @Description:中断
 * @Version: 1.0
 * @Since: 1.0
 */
public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("老王");
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi:"+i);
        }
        t.interrupt();//让等待线程继续
    }
}

class T extends Thread{
    @Override
    public void run() {
        while (true){
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()+":"+"正在吃包子！！！"+i);
            }
            try {
                System.out.println(Thread.currentThread().getName()+":"+"休眠中！！！");
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+":"+"被中断了！！！");
            }
        }
    }
}