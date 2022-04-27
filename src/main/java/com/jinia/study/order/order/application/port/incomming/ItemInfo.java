package com.jinia.study.order.order.application.port.incomming;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ItemInfo {
    @Getter
    @AllArgsConstructor
    public static class ItemVO{
        private final String itemToken;
        private final String itemName;
        private final Long itemPrice;
        private final String status;
    }
}
