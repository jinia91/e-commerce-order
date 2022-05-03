package com.jinia.study.order.order.adapter.outgoing.persistence.item;

import com.jinia.study.order.order.adapter.outgoing.persistence.token.TokenGenerator;
import com.jinia.study.order.order.application.port.outgoing.item.ItemRepositoryPort;
import com.jinia.study.order.order.domain.item.Item;
import com.jinia.study.order.order.domain.item.ItemToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryAdapter implements ItemRepositoryPort {
    static private final String ITEM_PREFIX = "itm_";
    private final JpaItemRepository jpaRepository;
    private final TokenGenerator tokenGenerator;

    @Override
    public void store(Item item) {
        jpaRepository.save(item);
    }

    @Override
    public ItemToken newOneToken(){
        return new ItemToken(tokenGenerator.nextOneToken(ITEM_PREFIX));
    }
}
