package dingxiang.com.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

    @Value("${from}")
    private String from;

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }


    @RequestMapping("/from")
    public String from() {
        return this.from;
    }
}
