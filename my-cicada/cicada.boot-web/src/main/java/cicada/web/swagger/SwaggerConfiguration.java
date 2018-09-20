package cicada.web.swagger;


import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
    @Autowired
    Environment env;

    public SwaggerConfiguration() {
    }

    @Bean
    public Docket api() {
        Predicate<RequestHandler> contion = new Predicate<RequestHandler>() {
            public boolean apply(RequestHandler input) {
                Class<?> declaringClass = input.declaringClass();
                if (declaringClass == BasicErrorController.class) {
                    return false;
                } else if (declaringClass.isAnnotationPresent(RestController.class)) {
                    return true;
                } else {
                    return input.isAnnotatedWith(ResponseBody.class);
                }
            }
        };
        Docket docket = (new Docket(DocumentationType.SWAGGER_2)).select().paths(PathSelectors.any()).apis(contion).build();
        docket.apiInfo(this.apiInfo()).securitySchemes(Lists.newArrayList(new ApiKey[]{this.apiKey()})).genericModelSubstitutes(new Class[]{ResponseEntity.class});
        return docket;
    }

    private ApiKey apiKey() {
        return new ApiKey("mykey", "Authentication", "header");
    }

    private ApiInfo apiInfo() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title(this.env.getProperty("Swagger.Title"));
        apiInfoBuilder.description(this.env.getProperty("Swagger.Description"));
        apiInfoBuilder.version(this.env.getProperty("Swagger.Version"));
        return apiInfoBuilder.build();
    }
}
