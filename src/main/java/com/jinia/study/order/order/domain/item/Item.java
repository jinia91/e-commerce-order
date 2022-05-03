package com.jinia.study.order.order.domain.item;

import com.jinia.study.order.order.domain.BasicEntity;
import com.jinia.study.order.order.domain.Money;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Embedded
    private ItemToken itemToken;
    @Column(nullable = false)
    private String itemName;
    @Embedded
    private Money itemPrice;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
    private String description;

    @Getter
    @RequiredArgsConstructor
    public enum Status{
        ON_SALE("판매중"),
        ON_BID("입찰중"),
        END_OF_SALE("판매 종료");

        private final String description;
    }

    public static Item newOne(String itemName, Money itemPrice, ItemToken itemToken, String sellerToken, String description) {
        return new Item(itemName,itemPrice, Status.ON_SALE, itemToken, description);
    }

    public Item(String itemName, Money itemPrice, Status status, ItemToken itemToken, String description) {
        if(StringUtils.isEmpty(itemName)) throw new InvalidParamException("Item.itemName");
        if(status == null) throw new InvalidParamException("Item.itemName");
        if(itemToken == null) throw new InvalidParamException("Item.itemToken");

        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.status = status;
        this.itemToken = itemToken;
        this.description = description;
    }
}
