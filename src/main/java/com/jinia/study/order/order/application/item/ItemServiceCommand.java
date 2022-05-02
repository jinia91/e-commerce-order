package com.jinia.study.order.order.application.item;

import com.jinia.study.order.order.application.port.incomming.item.ItemCommand;
import com.jinia.study.order.order.domain.item.Item;
import com.jinia.study.order.order.domain.item.ItemToken;
import com.jinia.study.order.order.domain.Money;
import lombok.Getter;
import lombok.ToString;

public class ItemServiceCommand {

    static public RegisterItem registerItemCmdFrom(ItemCommand.RegisterItem command){
        return new RegisterItem(command.getItemName(),
                Money.wons(command.getItemPrice()),
                command.getSellerToken(),
                command.getItemDescription());
    }

    @Getter
    @ToString
    public static class RegisterItem {
        private final String itemName;
        private final Money itemPrice;
        private final String sellerToken;
        private final String itemDescription;

        private RegisterItem(String itemName, Money itemPrice, String sellerToken, String itemDescription) {
            this.itemName = itemName;
            this.itemPrice = itemPrice;
            this.sellerToken = sellerToken;
            this.itemDescription = itemDescription;
        }

        public Item toEntity(ItemToken token){
            return Item.newOne(
                    this.itemName,
                    this.itemPrice,
                    token,
                    this.sellerToken,
                    this.itemDescription);
        }
    }


}
