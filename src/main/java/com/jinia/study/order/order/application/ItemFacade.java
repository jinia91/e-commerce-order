package com.jinia.study.order.order.application;

import com.jinia.study.order.order.application.port.incomming.ItemCommand;
import com.jinia.study.order.order.application.port.incomming.ItemInfo;
import com.jinia.study.order.order.application.port.incomming.ItemUseCase;
import org.springframework.stereotype.Service;

@Service
public class ItemFacade implements ItemUseCase {

    @Override
    public String registerItem(ItemCommand.RegisterItem command) {
        return null;
    }

    @Override
    public void changeOnSaleItem(String itemToken) {

    }

    @Override
    public void changeOnEndOfSaleItem(String itemToken) {

    }

    @Override
    public ItemInfo.ItemVO retrieveItemVO(String itemToken) {
        return null;
    }
}
