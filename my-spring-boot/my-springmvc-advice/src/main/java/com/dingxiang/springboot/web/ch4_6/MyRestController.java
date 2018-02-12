package com.dingxiang.springboot.web.ch4_6;

import com.dingxiang.springboot.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyRestController {

    @Autowired
    DemoService demoService;

    @RequestMapping(value = "/testRest" ,produces="text/plain;charset=UTF-8")
    public @ResponseBody String testRest(){

        return demoService.saySomething();
    }

}
