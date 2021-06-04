package com.example.demo.async.Async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class AsyncTask {
    @Async("asyncExecutor")
    public void foo() {
        try{
            TimeUnit.SECONDS.sleep(1);
            System.out.println("sync finish");
        }catch (Exception ignored) {
        }
    }
}
