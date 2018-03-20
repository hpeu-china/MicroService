package com.mycat.monoeshop;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Channel {
    String MY_INPUT = "myInput";

    @Input
    SubscribableChannel myInput();
}
