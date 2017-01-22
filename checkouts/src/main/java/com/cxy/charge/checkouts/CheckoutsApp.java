package com.cxy.charge.checkouts;

import com.cxy.checkouts.stream.CustomEvtClient;
import com.cxy.checkouts.stream.Source;
import com.cxy.gw.charge.checkouts.apis.IHello;
import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */

@SpringCloudApplication
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
@RestController
@EnableBinding(Source.class)
public class CheckoutsApp implements IHello {
    public static void main(String[] args) {
        SpringApplication.run(CheckoutsApp.class, args);
    }

    @RequestMapping(value = "/use-feign/hello")
    public String hello() {
        return "hello";
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return feign.Logger.Level.FULL;
    }
}
