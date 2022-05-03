package com.jinia.study.order.order.application.item;

import com.jinia.study.order.order.application.port.incomming.item.ItemInfo;
import com.jinia.study.order.order.application.port.outgoing.item.ItemReaderPort;
import com.jinia.study.order.order.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ItemQueries {
    private final ItemReaderPort itemReaderPort;

    public ItemInfo.ItemVO retrieveItemInfo(ItemServiceQuery.RetrieveItem query) {
        Optional<Item> item = itemReaderPort.retrieveItem(query.getItemToken());

    }
}
