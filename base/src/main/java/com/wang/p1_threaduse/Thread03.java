package com.wang.p1_threaduse;
/**
 * @Author:wsz
 * @Date: 2023/1/2 16:48
 * @Description:Runnable实现多个线程
 * @Version: 1.0
 * @Since: 1.0
 */
public class Thread03 {
    public static void main(String[] args){

        Thread thread1 = new Thread(new T1());
        Thread thread2 = new Thread(new T2());
        thread1.start();
        thread2.start();
    }


}

class T1 implements Runnable{
    @Override
    public void run() {
        int times=0;
        while (true){
            System.out.println(Thread.currentThread().getName()+"执行！");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (times==10){
                break;
            }
        }
    }
}
class T2 implements Runnable{
    @Override
    public void run() {
        int times=0;
        while (true){
            System.out.println(Thread.currentThread().getName()+"执行！");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (times==10){
                break;
            }
        }

    }
}