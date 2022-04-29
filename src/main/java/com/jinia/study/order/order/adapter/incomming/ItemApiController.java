package com.jinia.study.order.order.adapter.incomming;

import com.jinia.study.order.order.application.port.incomming.ItemCommand;
import com.jinia.study.order.order.application.port.incomming.ItemUseCase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@ItemApiV1
@RequiredArgsConstructor
public class ItemApiController {
    private final ItemUseCase itemUseCase;
    private final ItemDtoMapper itemDtoMapper;

    @PostMapping
    public ResponseEntity<ItemResponse.RegisterItem> registerItem(@RequestBody @Valid ItemRequest.RegisterItem request){
        ItemCommand.RegisterItem command = itemDtoMapper.of(request);
        String itemToken = itemUseCase.registerItem(command);
        ItemResponse.RegisterItem response = itemDtoMapper.of(itemToken);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
