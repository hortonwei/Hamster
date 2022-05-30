package com.horton.config;

import com.horton.controller.AppController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import java.util.Objects;

/**
 * Quartz配置类
 */
@Configuration
public class QuartzConfig {
    /**
     * 1、创建Job对象
     */
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        //关联我们自己的Job类
        factoryBean.setJobClass(AppController.class);
        return factoryBean;
    }

    /**
     * 2、创建Trigger对象
     */
    @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        //关联JobDetail对象
        factoryBean.setJobDetail(Objects.requireNonNull(jobDetailFactoryBean.getObject()));
        //该参数表示一个执行的毫秒数
        factoryBean.setRepeatInterval(1800000); //每隔x毫秒执行一次, 30分钟
        //重复次数
        factoryBean.setRepeatCount(5000);
        return factoryBean;
    }

    /**
     * 3、创建Scheduler
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(SimpleTriggerFactoryBean simpleTriggerFactoryBean, MyadaptableJobFactory myadaptableJobFactory) {
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        //关联trigger
        factoryBean.setTriggers(simpleTriggerFactoryBean.getObject());
        factoryBean.setJobFactory(myadaptableJobFactory);//调用myadaptableJobFactory把对象注入到SpringIOC容器中
        return factoryBean;
    }
}
