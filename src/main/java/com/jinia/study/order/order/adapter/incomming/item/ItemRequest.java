package com.jinia.study.order.order.adapter.incomming.item;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

public class ItemRequest {

    @Getter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RegisterItem {
        @ApiModelProperty(required = true, notes = "상품명")
        @NotNull(message = "itemName 은 필수값입니다.")
        private String itemName;
        @ApiModelProperty(notes = "상품 가격")
        private Long itemPrice;
        @NotNull(message = "sellerToken 은 필수값입니다.")
        @ApiModelProperty(required = true, notes = "판매자 토큰")
        private String sellerToken;
        @ApiModelProperty(required = true, notes = "상품 설명")
        @NotNull(message = "itemDescription 은 필수값입니다")
        private String itemDescription;
    }
}
