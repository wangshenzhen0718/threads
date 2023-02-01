package com.wang.homework09;
/**
 * @Author:wsz
 * @Date: 2023/1/10 22:26
 * @Description:
 * @Version: 1.0
 * @Since: 1.0
 */
public class HomeWork02 {
    public static void main(String[] args){
        A a = new A();
        Thread A = new Thread(a);
        Thread B = new Thread(a);
        A.start();
        B.start();
    }
}
class A implements Runnable{
    private int money=10000;

    @Override
    public void run() {
        while (true){
            //解读
            //1。这里使用synchronized 实现了线程同步
            //2．当多个线程执行到这里时，就会去争夺this对象锁
            //3．哪个线程争夺到(获取)this对象锁，就执行synchronized 代码块，执行完后，会释放this对象锁
            //4．争夺不到this对象锁，就blocked ,准备继续争夺
            synchronized (this){
                if (money<=0){
                    System.out.println("没钱了。。。");
                    break;
                }
                money-=1000;
                System.out.println(Thread.currentThread().getName()+" 取了"+1000+"块钱，还剩"+(money));
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
