package com.cxy.coupons;

import com.cxy.checkouts.stream.CustomEvtClient;
import com.cxy.checkouts.stream.Sink;
import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */

@SpringCloudApplication
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
@RestController
@EnableBinding(Sink.class)
public class CouponsApp {
    public static void main(String[] args) {
        SpringApplication.run(CouponsApp.class, args);
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
