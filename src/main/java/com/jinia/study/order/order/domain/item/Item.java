package com.jinia.study.order.order.domain.item;

import com.jinia.study.order.shared.domain.BasicEntity;
import com.jinia.study.order.order.domain.Money;
import com.jinia.study.order.shared.domain.MemberId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "items")
public class Item extends BasicEntity {

    @EmbeddedId
    private ItemId id;
    @Column(nullable = false)
    private String itemName;
    @Embedded
    private Money itemPrice;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
    private String description;
    private MemberId sellerId;

    @Getter
    @RequiredArgsConstructor
    public enum Status{
        ON_SALE("판매중"),
        ON_BID("입찰중"),
        END_OF_SALE("판매 종료");

        private final String description;
    }

    public static Item newOne(String itemName, Money itemPrice, ItemId itemId, long sellerId, String description) {
        return new Item(itemName,itemPrice, Status.ON_SALE, itemId, description);
    }

    public Item(String itemName, Money itemPrice, Status status, ItemId itemId, String description) {
        if(itemId == null) throw new InvalidParamException("Item.itemId");
        if(StringUtils.isEmpty(itemName)) throw new InvalidParamException("Item.itemName");
        if(status == null) throw new InvalidParamException("Item.itemName");

        this.id = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.status = status;
        this.description = description;
    }
}
