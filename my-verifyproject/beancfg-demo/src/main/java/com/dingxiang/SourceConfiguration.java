package com.dingxiang;

import com.dingxiang.userRepositories.UserServiceRepository;
import com.dingxiang.userRepositories.UserServiceRepositoryImpl;
import com.dingxiang.userservicedriver.UserInfoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.dingxiang")
public class SourceConfiguration {

    /*
    * 方案一:
    * 接口和对应实现类不添加,任何声明bean的注解
    * 有链接数据库的,可以通过属性添加,注入bean的注解
    * */
    @Bean
    public UserServiceRepository userServiceRepository(UserInfoService.Iface iface) {
        return new UserServiceRepositoryImpl(iface);
    }
}
