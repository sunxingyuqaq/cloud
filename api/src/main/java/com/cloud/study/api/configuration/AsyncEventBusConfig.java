package com.cloud.study.api.configuration;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Sunxing Yu
 * @date 2019/9/12 16:11
 */
@Configuration
public class AsyncEventBusConfig {

    @Bean
    public AsyncEventBus asyncEventBus(){
        final ThreadPoolExecutor executor = executor();
        return new AsyncEventBus(executor);
    }

    private ThreadPoolExecutor executor() {
        ThreadFactory build = new ThreadFactoryBuilder()
                .setDaemon(false)
                .setNameFormat("bus thread pool")
                .build();
        return new ThreadPoolExecutor(2,2,0L,
                TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>(12),build);
    }
}
