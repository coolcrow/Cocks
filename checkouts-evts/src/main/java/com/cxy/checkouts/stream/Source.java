package com.cxy.checkouts.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by saga on 2017/1/9.
 */
public interface Source {

    String channel_output_name = "output_custom_evt";

    @Output(channel_output_name)
    MessageChannel submitCustomEvt();
}
