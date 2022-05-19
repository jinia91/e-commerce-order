package com.jinia.study.order.order.adapter.outgoing.persistence.item;

import com.jinia.study.order.order.application.port.outgoing.item.ItemRepositoryPort;
import com.jinia.study.order.order.domain.item.Item;
import com.jinia.study.order.order.domain.item.ItemId;
import com.jinia.study.order.shared.id_generator.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryAdapter implements ItemRepositoryPort {
    private final JpaItemRepository jpaRepository;
    private final IdGenerator idGenerator;

    @Override
    public void store(Item item) {
        jpaRepository.save(item);
    }

    @Override
    public ItemId getNextId(){
        return new ItemId(idGenerator.generate());
    }
}
