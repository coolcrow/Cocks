package com.cxy.gw.charge.checkouts;

import com.cxy.gw.charge.checkouts.apis.IEcho;
import com.cxy.gw.charge.checkouts.apis.IHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by saga on 2016/12/16.
 */
@RestController
public class SysSrvCtrl {

    @Autowired
    private IEchoStub echoStub;

    @Autowired
    private IEcho echoStub2;

    @Autowired
    private IHello hello;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/sys/services/echo", method = RequestMethod.GET)
    public String echo(@RequestParam String m) {
        String s = echoStub.echo(m);
        return s;
    }

    @RequestMapping(value = "/sys/services/echo2")
    public String echo2(String m) {
        String s = echoStub2.echo(m);
        return s;
    }

    @RequestMapping(value = "/sys/services/echo3", method = RequestMethod.GET)
    public String echo3(String m) {
        List<ServiceInstance> services = discoveryClient.getInstances("checkouts");
        System.out.println(services.size());
        for (ServiceInstance s : services)
            System.out.println(s.getUri());

        return "response ok.";
    }
}
