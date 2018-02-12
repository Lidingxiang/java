package com.dingxiang.springboot.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;


import java.io.IOException;

@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;
    private ResourceLoader resourceLoader;

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public  void outputResult(){

        System.out.println("bean的名称："+this.beanName);

        Resource resource= resourceLoader.getResource("classpath:com/dingxiang/springboot/aware/test.txt");

        try {
            System.out.println("加载文件内容："+ IOUtils.toString(resource.getInputStream()));
        }
        catch (IOException e){

            e.printStackTrace();
        }
    }
}
