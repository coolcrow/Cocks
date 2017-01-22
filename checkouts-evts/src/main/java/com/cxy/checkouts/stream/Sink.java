package com.cxy.checkouts.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by saga on 2017/1/9.
 */
public interface Sink {

    String channel_input_name = "input_custom_evt";

    @Input(channel_input_name)
    SubscribableChannel onCustomEvt();
}
