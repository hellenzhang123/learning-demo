package com.example.demo.config;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


@Configuration
public class ExecutorConfig extends AsyncConfigurerSupport {

    /** 
     * 设置线程池大小 
     **/
    private int corePoolSize = 4;
    /** 
     * 设置线程池最大数量 
     **/
    private int maxPoolSize = 16;
    /** 
     * 线程池阻塞队列的容量
     **/
    private int queueCapacity = 10;

//    private String threadNamePrefix = "omsAsyncExecutor-";

    @Bean
    @Override
    public ThreadPoolTaskExecutor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
//        executor.setThreadNamePrefix(threadNamePrefix);

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //一定要等线程执行完成的时候才去关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //最大等待时间60s
        executor.setAwaitTerminationSeconds(60);
        //项目启动的时候就初始化线程池，避免到调用的时候才初始化
        executor.initialize();
        return executor;
    }

}
