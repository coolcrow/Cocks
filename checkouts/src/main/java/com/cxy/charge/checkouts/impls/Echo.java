package com.cxy.charge.checkouts.impls;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.cxy.checkouts.stream.CustomEvtClient;
import com.cxy.checkouts.stream.Source;
import com.cxy.gw.charge.checkouts.apis.IEcho;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bus.SpringCloudBusClient;
import org.springframework.cloud.bus.event.CustomEvt;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by saga on 2016/12/15.
 */

@RestController
@DisconfFile(filename = "checkouts.echo.properties")
public class Echo extends Base implements IEcho {

    @Autowired
    //private CustomEvtClient customEvtClient;
    //SpringCloudBusClient springCloudBusClient;
    private Source source;

    @HystrixCommand
    @Override
    @RequestMapping(value = "/services/echo/{m}")
    public String echo(@PathVariable("m") String message) {
        CustomEvt customEvt = new CustomEvt(this, "100", "test");
        source.submitCustomEvt().send(MessageBuilder.withPayload(customEvt).build());

        return message;
    }

    @HystrixCommand
    @Override
    @RequestMapping(value = "/services/another_echo/{m}")
    public String anotherEcho(@PathVariable("m") String message) {
        return message;
    }
}
