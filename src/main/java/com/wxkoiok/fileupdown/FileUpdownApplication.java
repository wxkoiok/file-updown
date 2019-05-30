package com.wxkoiok.fileupdown;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author wuxiang
 * @since 2019/05/29
 */
@SpringBootApplication
public class FileUpdownApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FileUpdownApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FileUpdownApplication.class);
    }

}
