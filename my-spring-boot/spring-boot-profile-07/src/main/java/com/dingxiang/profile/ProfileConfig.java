package com.dingxiang.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan("com.dingxiang.profile")
public class ProfileConfig {

    @Bean
    @Profile("dev")
    public DemoBean devDemoBean() {

        return new DemoBean("from development profile");
    }

    @Bean
    @Profile("prod")
    public DemoBean prodDemoBean() {

        return new DemoBean("from production profile");
    }
}