package com.jinia.study.order.order.adapter.outgoing.persistence.item;

import com.jinia.study.order.order.application.port.outgoing.item.ItemReaderPort;
import com.jinia.study.order.order.domain.item.Item;
import com.jinia.study.order.order.domain.item.ItemToken;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ItemReaderAdapter implements ItemReaderPort {
    private final JpaItemRepository jpaRepository;
    private final JPAQueryFactory queryFactory;


    @Override
    public Optional<Item> retrieveItem(ItemToken itemtoken) {
        return jpaRepository.findByItemToken(itemtoken);
    }
}
