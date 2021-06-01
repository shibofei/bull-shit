package com.example.demo.proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Student san = new Student("zhang san");

        StudentInvocationHandler<Person> studentHandler = new StudentInvocationHandler<>(san);

        Person studentProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),new Class<?>[]{Person.class},studentHandler);

        studentProxy.giveMoney();

    }
}
