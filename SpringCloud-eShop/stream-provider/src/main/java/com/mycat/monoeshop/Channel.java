package com.mycat.monoeshop;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Channel {
    String MY_OUTPUT = "myOutput";

    @Output
    MessageChannel myOutput();
}
