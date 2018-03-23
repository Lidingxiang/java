package dingxiang.com.web;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "HELLO-SERVICE")
public interface RefactorHelloService extends dingxiang.com.service.HelloService {
}
