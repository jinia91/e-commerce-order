package com.jinia.study.order.order.application.port.incomming.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

public class ItemQuery {

    @Getter
    @ToString
    @AllArgsConstructor
    public static class RetrieveItem{
        private String itemToken;
    }

}
