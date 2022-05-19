package com.jinia.study.order.order.application.port.outgoing.item;

import com.jinia.study.order.order.domain.item.Item;
import com.jinia.study.order.order.domain.item.ItemId;

public interface ItemRepositoryPort {
    ItemId getNextId();
    void store(Item item);
}
