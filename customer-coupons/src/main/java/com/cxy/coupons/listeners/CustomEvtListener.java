package com.cxy.coupons.listeners;

import com.cxy.checkouts.stream.CustomEvtClient;
import org.springframework.cloud.bus.event.CustomEvt;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * Created by saga on 2017/1/7.
 */
@Component
public class CustomEvtListener {

    @StreamListener(CustomEvtClient.channel_input_name)
    public void onCustomEvt(CustomEvt customEvt) {
        System.out.println("received custom event:" + customEvt.getName());
    }
}
