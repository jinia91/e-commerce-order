package com.jinia.study.order.order.adapter.incomming;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

public class ItemResponse {
    @Getter
    @ToString
    @AllArgsConstructor
    public static class RegisterItem {
        private final String itemToken;
    }
}
