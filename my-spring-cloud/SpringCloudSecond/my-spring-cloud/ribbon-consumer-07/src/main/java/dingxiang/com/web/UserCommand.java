package dingxiang.com.web;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

/*
* 通过继承的方式来实现缓存的功能
* */
public class UserCommand extends HystrixCommand<User> {


    private RestTemplate restTemplate;
    private Long id;

    public UserCommand(Setter setter, RestTemplate restTemplate, Long id) {
        super(setter);
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected User run() throws Exception {
        return restTemplate.getForObject("http://USER-SERVICE/users/{1}", User.class, id);
    }

    /*
    * 缓存
    * */
    @Override
    protected String getCacheKey() {
        return String.valueOf(id);
    }
}
