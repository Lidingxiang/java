package cicada.filesystem.config;


import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class FileBean {
    public FileBean() {
    }

    public CommonsMultipartResolver multipartConfigElement() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("UTF-8");
        multipartResolver.setMaxUploadSize(1048576000L);
        multipartResolver.setMaxInMemorySize(40960);
        return multipartResolver;
    }
}