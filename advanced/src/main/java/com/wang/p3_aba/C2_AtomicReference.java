package com.wang.p3_aba;

import java.util.concurrent.atomic.AtomicReference;

public class C2_AtomicReference {
    public static void main(String[] args) {
        AtomicReference atomicReference = new AtomicReference();
        User zs = new User("zs", 18);
        User ls = new User("ls", 19);
        atomicReference.set(zs);
        System.out.println(atomicReference.compareAndSet(zs, ls) + "\t当前用户" + atomicReference.get());
        System.out.println(atomicReference.compareAndSet(ls, zs) + "\t当前用户" + atomicReference.get());
    }
}
