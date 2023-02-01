package com.wang.exit02;

/**
 * @Author:wsz
 * @Date: 2023/1/2 20:30
 * @Description:线程终止
 * @Version: 1.0
 * @Since: 1.0
 */
public class ThreadExit {
    public static void main(String[] args){
      //
        T t = new T();
        t.start();

        try {
            System.out.println("主线程休眠10s");
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t.setFlag(false);
    }

}

class T extends Thread {

    private int count = 0;
    private boolean flag = true;
    @Override
    public void run() {
        while (flag){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+":"+count++);
        }


    }

    public void setFlag(boolean flag){
        this.flag=flag;
    }
}

