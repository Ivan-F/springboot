package cn.just_do.springboot.common.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

//@Configuration
public class AsyncConfig {

    /** Set the ThreadPoolExecutor's core pool size. */
    @Value("${async.corePoolSize}")
    private int corePoolSize;
    /** Set the ThreadPoolExecutor's maximum pool size. */
    @Value("${async.maxPoolSize}")
    private int maxPoolSize;
    /** Set the capacity for the ThreadPoolExecutor's BlockingQueue. */
    @Value("${async.queueCapacity}")
    private int queueCapacity;

    @Bean
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        System.out.println("ThreadPoolTask Init...");
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.initialize();
        System.out.println("\n");
        System.out.println("ThreadPoolTask ready...");
     return executor;
    }
}
