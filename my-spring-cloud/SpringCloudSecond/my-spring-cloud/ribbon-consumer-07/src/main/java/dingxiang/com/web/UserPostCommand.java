package dingxiang.com.web;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

/*
* 更新缓存内容
* */
public class UserPostCommand extends HystrixCommand<User> {

    private RestTemplate restTemplate;
    private User user;

    public UserPostCommand(RestTemplate restTemplate, User user) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GetSetGet")));
        this.restTemplate = restTemplate;
        this.user = user;
    }

    @Override
    protected User run() throws Exception {
        //写操作
        User r = restTemplate.postForObject("http://USER-SERVICE/users", user, User.class);
        //刷新缓存, 清理缓存中失效的User
        UserGetCommand.flushCache(user.getId());
        return r;
    }
}
