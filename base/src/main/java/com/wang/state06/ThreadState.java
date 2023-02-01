package com.wang.state06;

public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        System.out.println("当前状态为"+t1.getState());
        t1.start();
        System.out.println("当前状态为"+t1.getState());
        while(!Thread.State.TERMINATED.equals(t1.getState())){
            System.out.println("当前状态为"+t1.getState());
            Thread.sleep(1000);
        }
        System.out.println("当前状态为"+t1.getState());

    }
}

class T1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hi"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
