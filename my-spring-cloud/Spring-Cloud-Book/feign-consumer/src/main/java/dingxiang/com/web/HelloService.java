package dingxiang.com.web;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "hello-service")
public interface HelloService {

    @RequestMapping("/hello")
    String hello();
}
