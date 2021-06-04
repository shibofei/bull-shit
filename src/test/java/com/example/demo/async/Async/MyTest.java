package com.example.demo.async.Async;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    private AsyncTask asyncTask;

    @Test
    public void test() throws InterruptedException {
        asyncTask.foo();
        TimeUnit.SECONDS.sleep(2);
    }
}
