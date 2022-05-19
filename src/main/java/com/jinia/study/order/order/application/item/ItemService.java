package com.jinia.study.order.order.application.item;

import com.jinia.study.order.order.application.port.outgoing.item.ItemRepositoryPort;
import com.jinia.study.order.order.domain.item.ItemId;
import com.jinia.study.order.order.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepositoryPort itemRepositoryPort;

    @Transactional
    public ItemId registerItem(ItemServiceCommand.RegisterItem command) {
        Item item = command.toEntity(itemRepositoryPort.getNextId());
        itemRepositoryPort.store(item);
        return item.getId();
    }
}
