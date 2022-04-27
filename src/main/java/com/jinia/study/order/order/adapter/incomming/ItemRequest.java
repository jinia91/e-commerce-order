package com.jinia.study.order.order.adapter.incomming;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

public class ItemRequest {
    @Getter
    @ToString
    @AllArgsConstructor
    public static class RegisterItem {
        @NotNull(message = "itemName 은 필수값입니다.")
        private final String itemName;
        private final Long itemPrice;
        @NotNull(message = "partnerToken 은 필수값입니다.")
        private final String partnerToken;
    }
}
