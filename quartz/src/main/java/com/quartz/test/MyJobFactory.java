package com.quartz.test;

import org.quartz.Job;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;

/**
 * author 45208
 * date 2017/5/29
 **/
public class MyJobFactory extends AdaptableJobFactory{
    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

   protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception{
       Object o = super.createJobInstance(bundle);
       autowireCapableBeanFactory.autowireBean(o);
       return o;
   }
}
