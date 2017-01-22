package com.cxy.gw.charge.checkouts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */

@SpringCloudApplication
@EnableZuulProxy
@EnableFeignClients
@RestController
public class GwApp {
    public static void main(String[] args) {
        SpringApplication.run(GwApp.class, args);
    }
}
