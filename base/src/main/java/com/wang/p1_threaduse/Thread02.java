package com.wang.p1_threaduse;
/**
 * @Author:wsz
 * @Date: 2023/1/2 16:48
 * @Description:实现Runnable实现多线程
 * @Version: 1.0
 * @Since: 1.0
 */
public class Thread02 {
    public static void main(String[] args){

        Thread thread = new Thread(new Dog());
        thread.start();
    }


}
class Dog implements Runnable{
    @Override
    public void run() {
        int times=0;
        while (true){
            System.out.println("汪汪！！狗狗汪汪叫！！！"+times+++" "+Thread.currentThread().getName());
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