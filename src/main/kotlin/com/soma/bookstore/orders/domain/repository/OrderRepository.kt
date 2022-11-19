package com.soma.bookstore.orders.domain.repository

import com.soma.bookstore.orders.domain.model.Order

interface OrderRepository {

    fun save(order: Order): Order

    fun find(id: Long): Order?

    fun findAll(): List<Order>
}