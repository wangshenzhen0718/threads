package com.wang.p8_lock;
/**
 * @Author:wsz
 * @Date: 2023/1/7 22:31
 * @Description:模拟线程死锁
 * @Version: 1.0
 * @Since: 1.0
 */
public class DeadLock {

    public static void main(String[] args){
        DeadLockDemo A = new DeadLockDemo(true);
        A.setName("A");
        DeadLockDemo B = new DeadLockDemo(false);
        B.setName("B");
        A.start();
        B.start();

    }
}

class DeadLockDemo extends Thread{
    static Object o1=new Object();
    static Object o2=new Object();
    boolean flag;
    public DeadLockDemo(boolean flag){
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag){
            synchronized (o1){
                System.out.println(Thread.currentThread().getName()+" 进入1");
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName()+" 进入2");
                }
            }
        }else {
            synchronized (o2){
                System.out.println(Thread.currentThread().getName()+" 进入3");
                synchronized (o1){
                    System.out.println(Thread.currentThread().getName()+" 进入4");
                }
            }
        }

    }
}
