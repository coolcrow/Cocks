package com.cxy.charge.checkouts;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import com.cxy.checkouts.stream.Source;
import com.cxy.gw.charge.checkouts.apis.IHello;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
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
@ImportResource("disconf.xml")
@DisconfFile(filename = "application.yaml")
@DisconfUpdateService(confFileKeys = {"application.yaml"})
public class CheckoutsApp implements ApplicationContextAware, IDisconfUpdate {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ApplicationContext ctx;

    private static ConfigurableApplicationContext appCtx;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(CheckoutsApp.class);
        application.setAdditionalProfiles(System.getProperty("CHECKOUTS_PROFILE", "dev"));

        //application.addListeners();
        appCtx = application.run(args);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }


    @Override
    public void reload() throws Exception {
        logger.info("application.yaml changed. refresh now.");

        appCtx.stop();
        appCtx.start();

        logger.info("refresh done.");
    }
}
