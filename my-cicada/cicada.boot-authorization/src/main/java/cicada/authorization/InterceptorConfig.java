package cicada.authorization;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    public InterceptorConfig() {
    }

    public void addInterceptors(InterceptorRegistry registry) {
        AuthorizationInterceptor interceptor = new AuthorizationInterceptor();
        registry.addInterceptor(interceptor).addPathPatterns(new String[]{"/**"});
    }
}