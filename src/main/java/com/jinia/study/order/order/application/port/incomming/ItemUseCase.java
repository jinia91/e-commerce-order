package com.jinia.study.order.order.application.port.incomming;

public interface ItemUseCase {
    String registerItem(ItemCommand.RegisterItem command);
    void changeOnSaleItem(String itemToken);
    void changeOnEndOfSaleItem(String itemToken);
    ItemInfo.ItemVO retrieveItemVO(String itemToken);
}
