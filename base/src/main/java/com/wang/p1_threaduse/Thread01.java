package com.wang.p1_threaduse;
/**
 * @Author:wsz
 * @Date: 2023/1/2 16:48
 * @Description:集成Thread类实现多线程
 * @Version: 1.0
 * @Since: 1.0
 */
public class Thread01 {
    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName());
      //
        Cat cat = new Cat();
        /*1.public synchronized void start() {
                start0();
         }
         2.private native void start0();真正实现多线程的方法
         */
        cat.start();
        //cat.run();//run方法就是一个普通的方法，没有真正的启动一个线程，就会把run方法执行完毕，才向下执行

        System.out.println("哈哈哈哈");
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+i);
        }
    }


}

class Cat extends Thread{
    @Override
    public void run() {
        int times=0;
        while (true){
            System.out.println("喵喵！！我是一只小猫猫！！！"+times+++" "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (times==100){
                break;
            }
        }

    }
}
