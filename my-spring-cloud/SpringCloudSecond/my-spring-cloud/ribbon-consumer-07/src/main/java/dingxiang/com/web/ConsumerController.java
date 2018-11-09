package dingxiang.com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    /*@Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer() {

        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
    }

    private void test1() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity =
                restTemplate.getForEntity("http://USER­SERVICE/user?name = {1}", String.class, "didi");
        String body = responseEntity.getBody();
    }*/


    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer() {

        return helloService.helloService();
    }
}
