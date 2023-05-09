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
    //1. 互斥:资源的锁是排他性的，加锁期间只能有一个线程拥有该资源。其他线程只能等待锁释放才能尝试获取该资源。
    static Object o1=new Object();
    static Object o2=new Object();
    boolean flag;
    public DeadLockDemo(boolean flag){
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag){
            // 2.请求和保持:当前线程已经拥有至少一个资源，但其同时又发出新的资源请求，而被请求的资源被其他线程拥有。此时进入保持当前资源并等待下个资源的状态。
            // 3.线程已拥有的资源，只能由自己释放，不能被其他线程剥夺。
            // 4.循环等待：是指有多个线程互相的请求对方的资源，但同时拥有对方下一步所需的资源。形成一种循环，类似2)请求和保持。但此处指多个线程的关系。并不是指单个线程一直在循环中等待。
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
