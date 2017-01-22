package com.cxy.gw.charge.checkouts.apis;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by saga on 2016/12/14.
 */


@FeignClient("checkouts")
public interface IEcho {

    @RequestMapping(value = "/services/echo/{m}")
    String echo(@PathVariable("m") String m);

    @RequestMapping(value = "/services/another_echo/{m}")
    String anotherEcho(@PathVariable("m") String m);
}
