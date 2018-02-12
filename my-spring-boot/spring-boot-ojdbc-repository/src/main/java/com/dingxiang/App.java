package com.dingxiang;

import com.dingxiang.dao.PersonRepository;
import com.dingxiang.support.CustomRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
public class App 
{
    @Autowired
    PersonRepository personRepository;

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
