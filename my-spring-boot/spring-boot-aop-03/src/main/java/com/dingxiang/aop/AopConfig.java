package com.dingxiang.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.dingxiang.aop")
@EnableAspectJAutoProxy
public class AopConfig {


}
