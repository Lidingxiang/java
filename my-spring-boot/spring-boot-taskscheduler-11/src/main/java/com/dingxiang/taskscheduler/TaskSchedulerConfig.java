package com.dingxiang.taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.dingxiang.taskscheduler")
@EnableScheduling //1开启对计划任务的支持
public class TaskSchedulerConfig {

}
