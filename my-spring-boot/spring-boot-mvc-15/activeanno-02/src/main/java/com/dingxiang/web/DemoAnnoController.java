package com.dingxiang.web;

import com.dingxiang.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/anno")
public class DemoAnnoController {

    //http://localhost:8080/activeanno-02-1.0-SNAPSHOT/anno
    @RequestMapping(produces = "text/plain;charset=UTF-8")	// 3
    public @ResponseBody String index(HttpServletRequest request) { // 4
        return "url:" + request.getRequestURL() + " can access";
    }

    //http://localhost:8080/activeanno-02-1.0-SNAPSHOT/anno/pathvar/123
    @RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8")// 5
    public @ResponseBody String demoPathVar(@PathVariable String str, //3
                                            HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access,str: " + str;
    }

    /*http://localhost:8080/mapping/anno/requestParam?id=1*/
    @RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8") //6
    public @ResponseBody String passRequestParam(Long id, HttpServletRequest request) {

        return "url:" + request.getRequestURL() + " can access,id: " + id;
    }

    /*http://localhost:8080/mapping/anno/obj?id=1&name=ldx*/
    @RequestMapping(value = "/obj", produces = "application/json;charset=UTF-8")//7
    @ResponseBody //8
    public String passObj(DemoObj obj, HttpServletRequest request) {

        return "url:" + request.getRequestURL()
                + " can access, obj id: " + obj.getId()+" obj name:" + obj.getName();
    }

    //http://localhost:8080/activeanno-02-1.0-SNAPSHOT/anno/name2
    @RequestMapping(value = { "/name1", "/name2" }, produces = "text/plain;charset=UTF-8")//9
    public @ResponseBody String remove(HttpServletRequest request) {

        return "url:" + request.getRequestURL() + " can access";
    }
}
