package com.wang.p7_syn;

/**
 * @Author:wsz
 * @Date: 2023/1/4 22:53
 * @Description: 线程同步 synchronized加到代码块上 参考文章理解：https://blog.csdn.net/my_sunshine26/article/details/125769089
 * @Version: 1.0
 * @Since: 1.0
 */
public class SellTicketCodeBlock {
    public static void main(String[] args){
        SellTicket02 sellTicket02 = new SellTicket02();
        Thread thread1 = new Thread(sellTicket02);
        Thread thread2 = new Thread(sellTicket02);
        Thread thread3 = new Thread(sellTicket02);
        thread1.start();
        thread2.start();
        thread3.start();
    }


}
class SellTicket02 implements Runnable{
    public int ticketNum=100;
    public boolean loop=true;
    Object obj=new Object();

    //静态方法锁加在SellTicket02.class
    public static void m1(){
        //类锁：每个类只有一个Class对象，所以每个类只有一个类锁；类锁是加载类上的，而类信息是存在JVM方法区的，并且整个JVM只有一份，方法区又是所有线程共享的，所以类锁是所有线程共享的
        synchronized (SellTicket02.class){
            System.out.println("m1");

}
    }


    //1. public synchronized void sell()语就是一个同步方法
    //2.这时锁在 this对象
    //3.也可以加在代码块上这时锁还是在 this对象
    public void sell(){

        //对象锁：每个实例都会有一个monitor对象，即Java对象的锁，类的对象可以有多个，所以每个对象有其独立的对象锁，互不干扰
        synchronized (obj/*this*/){
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


    }
    @Override
    public void run() {
        while (loop){
            sell();
        }
    }
}