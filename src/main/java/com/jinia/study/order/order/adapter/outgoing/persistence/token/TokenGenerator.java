package com.jinia.study.order.order.adapter.outgoing.persistence.token;

public interface TokenGenerator {
    String nextOneToken(String prefix);
}
