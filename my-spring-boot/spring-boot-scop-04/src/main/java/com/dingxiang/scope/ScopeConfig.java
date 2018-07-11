package com.dingxiang.scope;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //1
@ComponentScan("com.dingxiang.scope") //2
public class ScopeConfig {

}
