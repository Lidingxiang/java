package com.dingxiang.web;

import com.dingxiang.domain.DemoObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //1
@RequestMapping("/rest")
public class DemoRestController {

    //http://localhost:8080/activeanno-02-1.0-SNAPSHOT/rest/getjson?id=1&name=ldx
    @RequestMapping(value = "/getjson",produces={"application/json;charset=UTF-8"}) //2
    public DemoObj getjson (DemoObj obj){

        return new DemoObj(obj.getId()+1, obj.getName()+"yy");//3
    }

    @RequestMapping(value = "/getxml",produces={"application/xml;charset=UTF-8"})//4
    public DemoObj getxml(DemoObj obj){

        return new DemoObj(obj.getId()+1, obj.getName()+"yy");
    }
}
