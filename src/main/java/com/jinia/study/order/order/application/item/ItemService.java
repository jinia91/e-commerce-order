package com.jinia.study.order.order.application.item;

import com.jinia.study.order.order.application.port.outgoing.item.ItemRepositoryPort;
import com.jinia.study.order.order.domain.item.ItemToken;
import com.jinia.study.order.order.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepositoryPort itemRepositoryPort;

    @Transactional
    public ItemToken registerItem(ItemServiceCommand.RegisterItem command) {
        Item item = command.toEntity(itemRepositoryPort.newOneToken());
        itemRepositoryPort.store(item);
        return item.getItemToken();
    }
}
