package com.jinia.study.order.order.application.port.incomming.item;

public interface ItemUseCase {
    Long registerItem(ItemCommand.RegisterItem command);
    ItemInfo.ItemVO retrieveItemVO(String itemToken);
}
