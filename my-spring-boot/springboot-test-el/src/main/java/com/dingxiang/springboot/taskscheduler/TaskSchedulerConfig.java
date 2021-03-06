package com.dingxiang.springboot.taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.dingxiang.springboot.taskscheduler")
@EnableScheduling
public class TaskSchedulerConfig {
}
