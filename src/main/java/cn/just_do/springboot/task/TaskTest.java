package cn.just_do.springboot.task;

import cn.just_do.springboot.domain.TT;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

//@Component
public class TaskTest {

    private final static long ONE_Minute =  60 * 1000;

    @Scheduled(cron = "0/2 * * * * *")
    public void testTas(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("1-" + ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    /**
     * fixedDelay是当任务执行完毕后1分钟再执行
     */
    @Scheduled(fixedDelay=ONE_Minute)
    public void fixedDelayJob(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " >>fixedDelay执行....");
    }

    /**
     * fixedRate就是每多次分钟一次，不论你业务执行花费了多少时间
     */
    @Scheduled(fixedRate=ONE_Minute)
    public void fixedRateJob(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " >>fixedRate执行....");
    }
    @Scheduled(cron="0/1 * * * * ?")
    public void cronJob(){
        //{} 据说大括号是匿名内部类，不写这对括号，直接获取类型是获取不到的，类型会被虚拟机擦除
        TT<String> tt = new TT<String>(){};
        Type t = tt.getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType)t;
        System.out.println(pt.getActualTypeArguments()[0]);
    }
}
