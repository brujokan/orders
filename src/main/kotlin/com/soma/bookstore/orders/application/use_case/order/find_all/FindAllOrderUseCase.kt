package com.soma.bookstore.orders.application.use_case.order.find_all

import com.soma.bookstore.orders.domain.model.Order
import com.soma.bookstore.orders.domain.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class FindAllOrderUseCase(
    private val repository: OrderRepository
) {
    fun findAll(): List<Order> {
        return repository.findAll()
    }

}