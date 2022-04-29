package com.jinia.study.order.order.adapter.incomming;

import com.jinia.study.order.order.application.port.incomming.ItemCommand;
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
