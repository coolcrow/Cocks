package com.cxy.charge.checkouts.impls;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * Created by saga on 2017/1/7.
 */
@Component
public class Base implements ApplicationEventPublisherAware {

    protected ApplicationEventPublisher appEvtPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.appEvtPublisher = applicationEventPublisher;
    }
}
