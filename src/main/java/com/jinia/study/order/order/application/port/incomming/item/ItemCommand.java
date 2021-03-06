package com.jinia.study.order.order.application.port.incomming.item;

import lombok.*;

public class ItemCommand {
    @Getter
    @ToString
    @AllArgsConstructor
    public static class RegisterItem {
        private final String itemName;
        private final Long itemPrice;
        private final String sellerToken;
        private final String itemDescription;
    }
}
