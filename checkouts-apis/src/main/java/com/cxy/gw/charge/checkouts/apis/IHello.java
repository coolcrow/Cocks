package com.cxy.gw.charge.checkouts.apis;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by saga on 2016/12/19.
 */
@FeignClient("checkouts")
public interface IHello {
    @RequestMapping(value = "/use-feign/hello")
    String hello();
}
