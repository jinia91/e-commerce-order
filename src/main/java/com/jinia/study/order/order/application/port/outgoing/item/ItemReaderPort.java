package com.jinia.study.order.order.application.port.outgoing.item;

import com.jinia.study.order.order.domain.item.Item;
import com.jinia.study.order.order.domain.item.ItemId;

import java.util.Optional;

public interface ItemReaderPort {
    Optional<Item> retrieveItem(ItemId itemId);
}
