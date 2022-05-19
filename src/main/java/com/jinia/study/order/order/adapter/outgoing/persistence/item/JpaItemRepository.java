package com.jinia.study.order.order.adapter.outgoing.persistence.item;

import com.jinia.study.order.order.domain.item.Item;
import com.jinia.study.order.order.domain.item.ItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface JpaItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findById(ItemId itemId);
}
