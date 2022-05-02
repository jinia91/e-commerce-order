package com.jinia.study.order.order.application.item

import com.jinia.study.order.order.adapter.outgoing.persistence.item.ItemRepositoryAdapter
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class ItemServiceTests {

    @Mock lateinit var itemRepositoryAdapter: ItemRepositoryAdapter
    @InjectMocks lateinit var itemService: ItemService

    @Test
    fun`판매자가 상품을 등록하는 상황`(){

    }

}