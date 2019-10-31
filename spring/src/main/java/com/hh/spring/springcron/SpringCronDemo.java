package com.hh.spring.springcron;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.apache.commons.lang.time.DateFormatUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


@Component
public class SpringCronDemo {
    private static Logger _log = LoggerFactory.getLogger(SpringCronDemo.class);

    private int count = 1;



   // @Scheduled(cron="0/31 * * * * ? ")//每31秒
    //@Scheduled(cron="0/25 * * * * ? ")//每20秒
    @Scheduled(cron="0 0/1 * * * ?")//每一分钟
    public void springcron() throws InterruptedException {
        _log.info("定时任务开始执行");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        String format = DateFormatUtils.format(calendar.getTimeInMillis(), "yyyy-MM-dd HH:mm:ss");
        System.out.println("第"+ count++ +"次"+"在"+format+"时刻运行");
        System.out.println("开始休眠");
        TimeUnit.SECONDS.sleep(61);
        calendar.setTime(new Date());
        String format1 = DateFormatUtils.format(calendar.getTimeInMillis(), "yyyy-MM-dd HH:mm:ss");
        System.out.println("休眠后此刻时间"+format1);
    }
}
