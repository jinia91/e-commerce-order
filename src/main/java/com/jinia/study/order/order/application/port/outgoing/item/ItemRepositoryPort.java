package com.jinia.study.order.order.application.port.outgoing.item;

import com.jinia.study.order.order.domain.item.Item;
import com.jinia.study.order.order.domain.item.ItemToken;

public interface ItemRepositoryPort {
    ItemToken newOneToken();
    void store(Item item);
}
