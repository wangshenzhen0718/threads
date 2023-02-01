package com.wang.method04;

/**
 * @Author:wsz
 * @Date: 2023/1/2 21:40
 * @Description:线程插队
 * @Version: 1.0
 * @Since: 1.0
 */
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        for (int i=0;i<20;i++){
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+":"+"正在吃包子！！！"+i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //主线程执行5次后让子线程插队,一定会执行成功
            if (i==5) {
                t.join();
                /*t.yield();
                System.out.println("让老大吃包子！！");*/
            }
        }
    }
}

class T extends Thread{
    @Override
    public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+":"+"正在吃包子！！！"+i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
    }
}