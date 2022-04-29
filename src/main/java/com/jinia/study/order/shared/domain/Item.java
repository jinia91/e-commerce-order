package com.jinia.study.order.shared.domain;

import com.jinia.study.order.order.domain.item.InvalidParamException;
import com.jinia.study.order.order.domain.item.ItemToken;
import com.jinia.study.order.order.domain.item.Money;
import com.jinia.study.order.shared.domain.BasicEntity;
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

    @Getter
    @RequiredArgsConstructor
    public enum Status{
        PREPARE("판매 준비중"),
        ON_SALE("판매중"),
        END_OF_SALE("판매 종료");

        private final String description;
    }

    public Item(String itemName, Money itemPrice, Status status, ItemToken itemToken) {
        if(StringUtils.isEmpty(itemName)) throw new InvalidParamException("Item.itemName");
        if(status == null) throw new InvalidParamException("Item.itemName");
        if(itemToken == null) throw new InvalidParamException("Item.itemToken");

        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.status = status;
        this.itemToken = itemToken;
    }
}
