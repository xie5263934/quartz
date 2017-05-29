package com.quartz.test;

import com.test.sheldon.service.HelloService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author 45208
 * date 2017/5/28
 **/
public class SpringQuartz extends QuartzJobBean {
    @Autowired
    private HelloService helloService;
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz is running at:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        helloService.hello();
    }
}
