package com.wang.p3_aba;

class User {

    String userName;

    int age;

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("User [userName=%s, age=%s]", userName, age);
    }

}