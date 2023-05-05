package com.wang.p3_ticket;


public class SellTicket {
    public static void main(String[] args){
        SellTicket01 sellTicket01 = new SellTicket01();
        SellTicket01 sellTicket02 = new SellTicket01();
        SellTicket01 sellTicket03 = new SellTicket01();
        sellTicket01.start();
        sellTicket02.start();
        sellTicket03.start();
    }


}
class SellTicket01 extends Thread{
    public volatile static int ticketNum=100;
    @Override
    public void run() {
            while (true){
                if (ticketNum<=0){
                    System.out.println("售票结束。。。");
                    break;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+" 卖了第"+ticketNum+"张票，还剩"+--ticketNum);
            }



    }
}