package com.jinia.study.order.order.adapter.incomming.item;

import com.jinia.study.order.order.application.port.incomming.item.ItemCommand;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface ItemDtoMapper {
    ItemCommand.RegisterItem of(ItemRequest.RegisterItem request);
    ItemResponse.RegisterItem of(String itemToken);
}
