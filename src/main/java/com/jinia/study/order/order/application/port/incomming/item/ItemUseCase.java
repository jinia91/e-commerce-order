package com.jinia.study.order.order.application.port.incomming.item;

public interface ItemUseCase {
    String registerItem(ItemCommand.RegisterItem command);
    ItemInfo.ItemVO retrieveItemVO(String itemToken);
}
