package com.mycat.monoeshop.config;

import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.actuate.metrics.Metric;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Desc:
 *
 * @date: 14/11/2017
 * @author: gaul
 */
public class MyMetrix implements PublicMetrics {
    @Override
    public Collection<Metric<?>> metrics() {
        List<Metric<?>> metrix = new ArrayList<>();
        metrix.add(new Metric<Number>("metrix.my.memory.free", Runtime.getRuntime().freeMemory()));
        metrix.add(new Metric<Number>("metrix.my.memory.max", Runtime.getRuntime().maxMemory()));
        return metrix;
    }
}
