package com.wang.p9_homework;

import java.util.Scanner;

/**
 * @Author:wsz
 * @Date: 2023/1/10 21:11
 * @Description: 两个线程 A线程一直输出 B线程输入Q后 A停止
 * @Version: 1.0
 * @Since: 1.0
 */
public class HomeWork01 {
    public static void main(String[] args) throws InterruptedException {
        Thread01 thread01 = new Thread01();
        Thread02 thread02 = new Thread02(thread01);
        Thread thread1 = new Thread(thread01);
        Thread thread2 = new Thread(thread02);
        thread1.start();
        thread2.start();

    }

}

class Thread01 implements Runnable {

    private boolean flag = true;

    @Override
    public void run() {
        while (flag){
            System.out.println(Thread.currentThread().getName()+":"+(int)(Math.random()*100+1));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}


class Thread02 implements Runnable {

    private Thread01 thread01;
    Scanner scanner = new Scanner(System.in);

    public Thread02(Thread01 thread01) {
        this.thread01 = thread01;
    }

    @Override
    public void run() {
        while (true){
            System.out.println("请输入字母Q(退出！)");
            char c = scanner.next().toUpperCase().charAt(0);
            if (c=='Q'){
                thread01.setFlag(false);
                System.out.println("退出");
                break;

            }
        }

    }

}