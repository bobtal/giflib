package com.bobantalevski.giflib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class AppConfig {

//    @Autowired
//    private SpringTemplateEngine templateEngine;

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        templateEngine.addDialect(new Java8TimeDialect());
//    }

//    @Bean
//    public Java8TimeDialect java8TimeDialect() {
//        return new Java8TimeDialect();
//    }
}
