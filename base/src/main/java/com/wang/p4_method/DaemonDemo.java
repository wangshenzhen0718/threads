package com.wang.p4_method;

/**
 * @Author:wsz
 * @Date: 2023/1/2 21:40
 * @Description:守护线程，我们如果想要main线程结束后子线程也结束，将子线程设置为守护线程即可
 * @Version: 1.0
 * @Since: 1.0
 */
public class DaemonDemo {
    public static void main(String[] args) throws InterruptedException {
        T1 t = new T1();
        //线设置为守护进程再启动！！
        t.setDaemon(true);
        t.start();
        for (int i = 0; i < 20; i++) {
            Thread.sleep(1000);
            System.out.println("宝强正在工作！！！");
        }
        System.out.println("宝强工作结束！！！");
    }
}

class T1 extends Thread{
    @Override
    public void run() {
            for (;;) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+":"+"马蓉和宋哲开心的聊天！！！");

            }
    }
}