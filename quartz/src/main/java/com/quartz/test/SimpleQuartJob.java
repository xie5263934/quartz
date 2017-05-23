package com.quartz.test;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author JINRUN.XIE
 * @since 2017/5/18
 */
public class SimpleQuartJob implements Job{

    private static final Logger logger = LoggerFactory.getLogger(SimpleQuartJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("In SimpleQuartJob-it's job execute at |"+simpleDateFormat.format(new Date())+"|"+jobExecutionContext.getJobDetail().getJobClass().getSimpleName());
        logger.debug("this is a log4j test!");
    }


}
