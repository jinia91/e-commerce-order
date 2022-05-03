package com.jinia.study.order.order.application;

import com.jinia.study.order.order.application.item.ItemQueries;
import com.jinia.study.order.order.application.item.ItemService;
import com.jinia.study.order.order.application.item.ItemServiceCommand;
import com.jinia.study.order.order.application.port.incomming.item.ItemCommand;
import com.jinia.study.order.order.application.port.incomming.item.ItemInfo;
import com.jinia.study.order.order.application.port.incomming.item.ItemQuery;
import com.jinia.study.order.order.application.port.incomming.item.ItemUseCase;
import com.jinia.study.order.order.domain.item.ItemToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemFacade implements ItemUseCase {
    private final ItemService itemService;
    private final ItemQueries itemQueries;

    @Override
    public String registerItem(ItemCommand.RegisterItem command) {
        // TODO: 2022-05-02 1. 판매자 토큰 검증은 어떻게? 검증이 되었다고 가정? 캐쉬를 통해 검증?
        ItemServiceCommand.RegisterItem itemServiceCmd = ItemServiceCommand.registerItemCmdFrom(command);
        ItemToken itemToken = itemService.registerItem(itemServiceCmd);
        return itemToken.getToken();
    }

    @Override
    public ItemInfo.ItemVO retrieveItemVO(ItemQuery itemQuery) {
        itemQueries.retrieveItemInfo()
    }
}
