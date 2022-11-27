package com.mococo.api;

import java.util.TimeZone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.mococo.core"})
@ComponentScan(basePackages = {"com.mococo.api"})
@EntityScan(basePackages = {"com.mococo.core"})
@EnableJpaRepositories(basePackages = {"com.mococo.core"})
@SpringBootApplication
@EnableJpaAuditing
public class ApiApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
        SpringApplication.run(ApiApplication.class, args);
    }

}
