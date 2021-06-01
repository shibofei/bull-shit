package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StudentInvocationHandler<T> implements InvocationHandler {
    T target;
    public StudentInvocationHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy method: " + method.getName());

        Object result = method.invoke(target, args);

        return result;
    }
}
