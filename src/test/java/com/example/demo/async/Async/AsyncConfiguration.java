package com.example.demo.async.Async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class AsyncConfiguration implements AsyncConfigurer {

    @Bean
    public ThreadPoolTaskExecutor asyncExecutor(){
        System.out.println("init executor");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(3);
        executor.setKeepAliveSeconds(60);
        executor.setQueueCapacity(4);
        executor.setThreadNamePrefix("async-thread");
        return executor;
    }

    @Override
    public Executor getAsyncExecutor(){
        return asyncExecutor();
    }
}
