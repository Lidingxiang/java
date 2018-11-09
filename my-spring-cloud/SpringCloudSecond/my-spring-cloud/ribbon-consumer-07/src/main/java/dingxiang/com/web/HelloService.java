package dingxiang.com.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

@Service
public class HelloService {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    RestTemplate restTemplate;

    /*
    * 服务调用失败时调用特定方法[同步执行]
    * */
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService() {

        long start = System.currentTimeMillis();

        String result = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();

        long end = System.currentTimeMillis();
        logger.info("Spend Time :" + (end - start));
        return result;
    }

    public String helloFallback() {

        return "error";
    }

    /*
    * 方法的异步执行
    * */
    public Future<User> getUserByIdAsync(final String id) {
        return new AsyncResult<User>() {
            @Override
            public User invoke() {
                return restTemplate.getForObject("http://USER-SERVICE/users/{1}", User.class, id);
            }
        };
    }
}
