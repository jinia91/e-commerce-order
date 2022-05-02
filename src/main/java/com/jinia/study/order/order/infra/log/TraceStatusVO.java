package com.jinia.study.order.order.infra.log;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TraceStatusVO {
    private TraceId traceId;
    private Long startTimesMs;
    private String message;
}
