package com.jinia.study.order.order.application.item;

import com.jinia.study.order.order.application.port.incomming.item.ItemQuery;
import com.jinia.study.order.order.domain.item.ItemId;
import lombok.Getter;
import lombok.ToString;

public class ItemServiceQuery {

    static public RetrieveItem retrieveItemQueryFrom(ItemQuery.RetrieveItem query){
        return new RetrieveItem(query.getItemId());
    }

    @Getter
    @ToString
    public static class RetrieveItem {
        private final ItemId itemId;

        private RetrieveItem(Long itemId) {
            this.itemId = new ItemId(itemId);
        }
    }
}
