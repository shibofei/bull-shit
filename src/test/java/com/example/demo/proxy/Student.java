package com.example.demo.proxy;

public class Student implements Person{
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        System.out.println("give 5$");
    }
}
