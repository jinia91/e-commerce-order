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

    public static Item newOne(String itemName, Money itemPrice, ItemId itemId, String sellerId, String description) {
        // TODO: 2022-05-23 primitive 값을 컨트롤러단에서 변환해주기 / 어플리케이션에서 변환해주기 / 도메인에서 변환해주기
        // 과연 어디에서 변환해주는게 좋은설계일까?
        // 컨트롤러단에서 변환해주면 어플리케이션단에서 비지니스적으로 필요한 타입으로 래핑해서 들어오므로 보다 도메인주소 설계스러운 로직 구현 가능
        // 도메인단에서 변환해주면 구현이 편리
        // new MemberId(Long.parseLong(sellerId));
        return new Item(itemName,itemPrice, Status.ON_SALE, itemId, description);
    }

    public Item(String itemName, Money itemPrice, Status status, ItemId itemId, String description) {
        validate(itemName, status, itemId);

        this.id = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.status = status;
        this.description = description;
    }

    private void validate(String itemName, Status status, ItemId itemId) {
        if(itemId == null) throw new InvalidParamException("Item.itemId");
        if(StringUtils.isEmpty(itemName)) throw new InvalidParamException("Item.itemName");
        if(status == null) throw new InvalidParamException("Item.itemName");
    }
}
