package com.dingxiang;

import com.dingxiang.userRepositories.UserServiceRepository;
import com.dingxiang.userservicedriver.UserInfo;
import org.apache.thrift.TException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) throws TException {

        ConfigurableApplicationContext context = SpringApplication.run(App.class);
        UserServiceRepository userServiceRepository = context.getBean(UserServiceRepository.class);
        UserInfo userInfo = userServiceRepository.GetUsedInfoById("5774ee165924310dc403bf0b");

        System.out.println("====>" + userInfo.getTrueName());
    }
}
