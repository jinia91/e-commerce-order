package com.jinia.study.order.order.application.item;

import com.jinia.study.order.order.application.port.incomming.item.ItemCommand;
import com.jinia.study.order.order.application.port.incomming.item.ItemQuery;
import com.jinia.study.order.order.domain.Money;
import com.jinia.study.order.order.domain.item.Item;
import com.jinia.study.order.order.domain.item.ItemToken;
import lombok.Getter;
import lombok.ToString;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class ItemServiceQuery {

    static public RetrieveItem retrieveItemQueryFrom(ItemQuery.RetrieveItem query){
        return new RetrieveItem(query.getItemToken());
    }

    @Getter
    @ToString
    public static class RetrieveItem {
        private final ItemToken itemToken;

        private RetrieveItem(String itemToken) {
            this.itemToken = new ItemToken(itemToken);
        }
    }
}
