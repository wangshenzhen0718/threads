package com.wang.p7_syn;

/**
 * @Author:wsz
 * @Date: 2023/1/4 22:53
 * @Description: 线程同步 synchronized加到方法上
 * @Version: 1.0
 * @Since: 1.0
 */
public class SellTicketMethod {
    public static void main(String[] args){
        SellTicket01 sellTicket01 = new SellTicket01();
        Thread thread1 = new Thread(sellTicket01);
        Thread thread2 = new Thread(sellTicket01);
        Thread thread3 = new Thread(sellTicket01);
        thread1.start();
        thread2.start();
        thread3.start();
    }


}
class SellTicket01 implements Runnable{
    public int ticketNum=100;
    public boolean loop=true;
    //1. public synchronized void sell()语就是一个同步方法
    //2.这时锁在 this对象
    //3.也可以加在代码块上这时锁还是在 this对象
    public synchronized void sell(){

            if (ticketNum<=0){
                System.out.println("售票结束。。。");
                loop=false;
                return;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+" 卖了第"+ticketNum+"张票，还剩"+--ticketNum);

    }
    @Override
    public void run() {
        while (loop){
            sell();
        }
    }
}