package com.example.demo.config;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author
 * @description 定时任务配置类
 * @create 2017-11-24 上午9:48
 **/
@Component
@EnableScheduling
public class SchedulingConfiguration {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //每5秒钟执行一次
    @Scheduled(cron="*/5 * * * * *")
    public void reportCurrentTime() {
        System.out.println("当前时间：" + dateFormat.format(new Date()));
    }
    @Scheduled(cron="0 15 11 * * ?")
    public void reportEveryDay() {
        System.out.println("当前时间-----：" + dateFormat.format(new Date()));
    }
}
